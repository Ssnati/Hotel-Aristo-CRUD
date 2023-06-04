package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private final ActionListener actionListener;
    private JTabbedPane tabbedPane;
    private JTabbedPane tabbedPaneReservations;
    private PanelReservations addPanelReservations;
    private PanelReservations editPanelReservations;
    private PanelReservations deletePanelReservations;
    private PanelReservationsRead showPanelReservations;

    public MainPanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        setBackground(Color.black);
        initComponents();
        temporalEvents();
        searchEvents();
    }

    private void searchEvents() {

    }

    private void temporalEvents() {
        tabbedPaneReservations.setBackground(addPanelReservations.getBackground());
        tabbedPaneReservations.setForeground(Color.white);
        tabbedPaneReservations.setForegroundAt(tabbedPaneReservations.getSelectedIndex(), Color.black);
        tabbedPaneReservations.addChangeListener(e -> {
            tabbedPaneReservations.setForegroundAt(0,Color.white);
            tabbedPaneReservations.setForegroundAt(1,Color.white);
            tabbedPaneReservations.setForegroundAt(2,Color.white);
            tabbedPaneReservations.setForegroundAt(3,Color.white);
            tabbedPaneReservations.setForegroundAt(tabbedPaneReservations.getSelectedIndex(), Color.black);
        });
    }

    private void initComponents() {
        addPanelReservations = new PanelReservations();
        editPanelReservations = new PanelReservations();
        deletePanelReservations = new PanelReservations();
        showPanelReservations = new PanelReservationsRead();
        tabbedPane = new JTabbedPane();
        tabbedPaneReservations = new JTabbedPane(SwingConstants.LEFT);

        tabbedPaneReservations.addTab("R", showPanelReservations);
        tabbedPaneReservations.addTab("C", addPanelReservations);
        tabbedPaneReservations.addTab("U", editPanelReservations);
        tabbedPaneReservations.addTab("D", deletePanelReservations);
        tabbedPane.addTab("Reservas", tabbedPaneReservations);
        add(tabbedPane);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public JTabbedPane getTabbedPaneReservations() {
        return tabbedPaneReservations;
    }

    public void setTabbedPaneReservations(JTabbedPane tabbedPaneReservations) {
        this.tabbedPaneReservations = tabbedPaneReservations;
    }

    public PanelReservations getAddPanelReservations() {
        return addPanelReservations;
    }

    public void setAddPanelReservations(PanelReservations addPanelReservations) {
        this.addPanelReservations = addPanelReservations;
    }

    public PanelReservations getEditPanelReservations() {
        return editPanelReservations;
    }

    public void setEditPanelReservations(PanelReservations editPanelReservations) {
        this.editPanelReservations = editPanelReservations;
    }

    public PanelReservations getDeletePanelReservations() {
        return deletePanelReservations;
    }

    public void setDeletePanelReservations(PanelReservations deletePanelReservations) {
        this.deletePanelReservations = deletePanelReservations;
    }

    public PanelReservationsRead getShowPanelReservations() {
        return showPanelReservations;
    }

    public void setShowPanelReservations(PanelReservationsRead showPanelReservations) {
        this.showPanelReservations = showPanelReservations;
    }
}
