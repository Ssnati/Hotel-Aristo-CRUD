package view;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private final ActionListener actionListener;
    private final ChangeListener changeListener;
    private JTabbedPane tabbedPane;
    private JTabbedPane tabbedPaneReservations;
    private AddReservationsPanel addAddReservationsPanel;
    private EditReservationsPanel editReservationsPanel;
    private PanelReservationsRead panelReservationsRead;

    public MainPanel(ActionListener actionListener, ChangeListener changeListener) {
        this.actionListener = actionListener;
        this.changeListener = changeListener;
        setBackground(Color.black);
        initComponents();
        temporalEvents();
        searchEvents();
    }

    private void searchEvents() {

    }

    private void temporalEvents() {
        tabbedPaneReservations.setBackground(addAddReservationsPanel.getBackground());
        tabbedPaneReservations.setForeground(Color.white);
        tabbedPaneReservations.setForegroundAt(tabbedPaneReservations.getSelectedIndex(), Color.black);
        tabbedPaneReservations.addChangeListener(changeListener);
        tabbedPaneReservations.addChangeListener(e -> {
            tabbedPaneReservations.setForegroundAt(0, Color.white);
            tabbedPaneReservations.setForegroundAt(1, Color.white);
            tabbedPaneReservations.setForegroundAt(2, Color.white);
            tabbedPaneReservations.setForegroundAt(tabbedPaneReservations.getSelectedIndex(), Color.black);
        });
    }

    private void initComponents() {
        addAddReservationsPanel = new AddReservationsPanel(actionListener);
        editReservationsPanel = new EditReservationsPanel(actionListener);
        panelReservationsRead = new PanelReservationsRead(actionListener);
        tabbedPane = new JTabbedPane();
        tabbedPaneReservations = new JTabbedPane(SwingConstants.LEFT);

        tabbedPaneReservations.addTab("C", addAddReservationsPanel);
        tabbedPaneReservations.addTab("R y D", panelReservationsRead);
        tabbedPaneReservations.addTab("U", editReservationsPanel);
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

    public AddReservationsPanel getAddPanelReservations() {
        return addAddReservationsPanel;
    }

    public void setAddPanelReservations(AddReservationsPanel addAddReservationsPanel) {
        this.addAddReservationsPanel = addAddReservationsPanel;
    }

    public EditReservationsPanel getEditReservationsPanel() {
        return editReservationsPanel;
    }

    public void setEditReservationsPanel(EditReservationsPanel editReservationsPanel) {
        this.editReservationsPanel = editReservationsPanel;
    }

    public PanelReservationsRead getPanelReservationsRead() {
        return panelReservationsRead;
    }

    public void setPanelReservationsRead(PanelReservationsRead panelReservationsRead) {
        this.panelReservationsRead = panelReservationsRead;
    }

}
