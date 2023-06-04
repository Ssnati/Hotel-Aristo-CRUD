package view;

import javax.swing.*;
import java.awt.event.ActionListener;

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

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
