package presenter;

import model.BDManager;
import pojo.ReservasEntity;
import pojo.ReserveFullData;
import view.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements ActionListener, ChangeListener, WindowListener {
    private BDManager model;
    private View view;

    public Presenter() {
        model = new BDManager();
        view = new View(this, this);
        model.loadData();
    }

    public void start() {
        view.loadData(adaptToView(model.getReservas()), model.getPersonas(), model.getTiposAcomodacion(), model.getEmpresas());
        view.setVisible(true);
    }

    private List<ReserveFullData> adaptToView(List<ReservasEntity> modelReserves) {
        List<ReserveFullData> reserveFullData = new ArrayList<>();
        for (ReservasEntity modelReserve : modelReserves) {
            ReserveFullData reserve = new ReserveFullData();
            reserve.setIdReserve(modelReserve.getIdReserva());
            reserve.setReserveDate(modelReserve.getFechaReserva());
            reserve.setReserveValue(modelReserve.getValorReserva());
            reserve.setBookingCompanyName(model.getEmpresaById(modelReserve.getIdEmpresa()).getNombreEmpresa());
            reserve.setGuestName(model.getPersonaById(modelReserve.getIdPersonaHuesped()).getNombrePersona());
            reserve.setAcomodateTypeName(model.getTipoAcomodacionById(modelReserve.getIdTipoAcomodacion()).getNombreTipoAcomodacion());
            reserve.setReceptionistName(model.getPersonaById(modelReserve.getIdPersonaRecepcionista()).getNombrePersona());
            reserve.setReserveObservations(modelReserve.getObservacionesHuespedHotel());
            reserveFullData.add(reserve);
        }
        return reserveFullData;
    }

    public List<ReservasEntity> adaptToModel(List<ReserveFullData> viewReserves) {
        List<ReservasEntity> reserveFullData = new ArrayList<>();
        for (ReserveFullData viewReserve : viewReserves) {
            ReservasEntity reserve = new ReservasEntity();
            reserve.setIdReserva(viewReserve.getIdReserve());
            reserve.setFechaReserva(viewReserve.getReserveDate());
            reserve.setValorReserva(viewReserve.getReserveValue());
            reserve.setIdEmpresa(model.getEmpresaByName(viewReserve.getBookingCompanyName()).getIdEmpresa());
            reserve.setIdPersonaHuesped(model.getPersonaByName(viewReserve.getGuestName()).getIdPersona());
            reserve.setIdTipoAcomodacion(model.getTipoAcomodacionByName(viewReserve.getAcomodateTypeName()).getIdTipoAcomodacion());
            reserve.setIdPersonaRecepcionista(model.getPersonaByName(viewReserve.getReceptionistName()).getIdPersona());
            reserve.setObservacionesHuespedHotel(viewReserve.getReserveObservations());
            reserveFullData.add(reserve);
        }
        return reserveFullData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "saveEditReservation" -> {
                ReservasEntity entity = adaptToModel(view.getReserveToEdit()).get(0);
                entity.setValorReserva(model.getTipoAcomodacionById(entity.getIdTipoAcomodacion()).getPrecioAcomodacion());
                model.update(entity);
                view.getMainPanel().getTabbedPaneReservations().setSelectedIndex(1);
            }
            case "saveNewReservation" -> {
                ReservasEntity entity2 = adaptToModel(view.getNewReserve()).get(0);
                entity2.setValorReserva(model.getTipoAcomodacionById(entity2.getIdTipoAcomodacion()).getPrecioAcomodacion());
                model.save(entity2);
                view.getMainPanel().getTabbedPaneReservations().setSelectedIndex(1);
            }
            case "search" -> {
                String name = view.getMainPanel().getPanelReservationsRead().getSearchTextField().getText();
                if (name == null || name.isEmpty()) {
                    view.getMainPanel().getPanelReservationsRead().loadData(adaptToView(model.getReservas()));
                } else {
                    if (name.matches("[0-9]+")) {
                        view.loadData(adaptToView(List.of(model.getReservasById(Integer.parseInt(name)))), model.getPersonas(), model.getTiposAcomodacion(), model.getEmpresas());
                    } else {
                        view.loadData(adaptToView((model.getReservasByName(name))), model.getPersonas(), model.getTiposAcomodacion(), model.getEmpresas());
                    }
                }
            }
            case "delete" -> {
                if (view.getMainPanel().getPanelReservationsRead().getReservationsTable().getSelectedRow() == -1) {
                    view.showMessage("Seleccione una reserva");
                } else {
                    String information = String.valueOf(view.getMainPanel().getPanelReservationsRead().getReservationsTable().getValueAt(view.getMainPanel().getPanelReservationsRead().getReservationsTable().getSelectedRow(), 0));
                    if (information != null && !information.isEmpty()) {
                        model.delete(Integer.parseInt(information));
                        view.getMainPanel().getPanelReservationsRead().loadData(adaptToView(model.getReservas()));
                    }
                }
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        model.close();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int index = view.getMainPanel().getTabbedPaneReservations().getSelectedIndex();
        switch (index) {
            case 2 -> {
                String data = view.showDialog("Ingrese el ID de la reserva a editar");
                if (data == null || data.isEmpty()) {
                    view.getMainPanel().getTabbedPaneReservations().setSelectedIndex(1);
                } else {
                    view.loadEditReserve(adaptToView(List.of(model.getReservasById(Integer.parseInt(data)))).get(0));
                }
            }
            case 1, 0 -> view.getMainPanel().getPanelReservationsRead().loadData(adaptToView(model.getReservas()));
        }
    }

    public void reconfigure() {
        for (ReservasEntity entity:model.getReservas()){
            entity.setValorReserva(model.getTipoAcomodacionById(entity.getIdTipoAcomodacion()).getPrecioAcomodacion());
            model.update(entity);
        }
    }
}