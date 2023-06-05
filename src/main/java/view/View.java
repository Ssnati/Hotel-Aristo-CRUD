package view;

import pojo.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.List;

public class View extends JFrame {
    private MainPanel mainPanel;

    public View(ActionListener actionListener, ChangeListener changeListener) {
        super("Base de datos Hotel Aristo");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents(actionListener, changeListener);
    }

    private void initComponents(ActionListener actionListener, ChangeListener changeListener) {
        mainPanel = new MainPanel(actionListener, changeListener);
        add(mainPanel);
    }

    public void loadData(List<ReserveFullData> reservas, List<PersonasEntity> personas, List<TiposAcomodacionEntity> tiposAcomodacion, List<EmpresasEntity> empresas) {
        mainPanel.getAddPanelReservations().loadData(personas, tiposAcomodacion, empresas);
        mainPanel.getEditReservationsPanel().loadData(personas, tiposAcomodacion, empresas);
        mainPanel.getPanelReservationsRead().loadData(reservas);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public String showDialog(String message) {
        return JOptionPane.showInputDialog(this, message);
    }

    public void loadEditReserve(ReserveFullData reserve) {
        mainPanel.getEditReservationsPanel().loadEditReserve(reserve);
    }

    public List<ReserveFullData> getReserveToEdit() {
        return List.of(mainPanel.getEditReservationsPanel().getReserveToEdit());
    }

    public List<ReserveFullData> getNewReserve() {
        return List.of(mainPanel.getAddPanelReservations().getNewReserve());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
