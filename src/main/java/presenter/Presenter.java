package presenter;

import model.BDManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.PersonasEntity;
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
            case "deleteReservation" -> {
                String data = view.showDialog("Ingrese el ID de la reserva a eliminar");
                if (data != null && !data.isEmpty()){
                    model.delete(Integer.parseInt(data));
                }
                view.getMainPanel().getTabbedPaneReservations().setSelectedIndex(1);
            }
        }
    }

    public void read() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            PersonasEntity persona = session.get(PersonasEntity.class, 1);
            List<PersonasEntity> personas = new ArrayList<>();
            personas.add(searchPersonByDocumentNumber(session, 1));
            for (PersonasEntity p : personas) {
                System.out.println(p);
            }
        }
    }

    private PersonasEntity searchPersonByDocumentNumber(Session session, int i) {
        PersonasEntity persona = session.get(PersonasEntity.class, i);
        return persona;
    }

    public void delete() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            PersonasEntity persona = session.get(PersonasEntity.class, 1);
            session.remove(persona);

            session.getTransaction().commit();
        }
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
            case 1, 0 -> view.getMainPanel().getShowPanelReservations().loadData(adaptToView(model.getReservas()));
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

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
}