package view;

import pojo.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class View extends JFrame {
    private MainPanel mainPanel;

    public View(ActionListener actionListener) {
        super("Base de datos Hotel Aristo");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        mainPanel = new MainPanel(actionListener);
        add(mainPanel);
    }

    public void loadData(List<ReserveFullData> reservas, List<PersonasEntity> personas, List<TiposAcomodacionEntity> tiposAcomodacion, List<EmpresasEntity> empresas) {
        mainPanel.getAddPanelReservations().loadData(personas, tiposAcomodacion, empresas);
        mainPanel.getEditReservationsPanel().loadData(personas, tiposAcomodacion, empresas);
        mainPanel.getShowPanelReservations().loadData(reservas);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
