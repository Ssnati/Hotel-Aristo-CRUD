package view;

import javax.swing.*;
import java.awt.*;

public class PanelReservations extends JPanel {
    private JLabel reservationDateLabel;
    private JLabel reservationValueLabel;
    private JLabel idEnterpriseLabel;
    private JLabel idGuestLabel;
    private JLabel idAccomodationType;
    private JLabel idRecepcionistLabel;
    private JLabel guestCommentsLabel;
    private JTextField reservationValueTextField;
    private JTextField idEnterpriseTextField;
    private JTextField idGuestTextField;
    private JTextField idAccomodationTypeTextField;
    private JTextField idRecepcionistTextField;
    private JTextArea guestCommentsTextArea;
    private DatePickerPanel reservationDatePickerPanel;
    private JButton saveButton;
    private final int COMPONENT_WIDTH = 212;
    private final int COMPONENT_HEIGHT = 35;

    public PanelReservations() {
        setLayout(new GridBagLayout());
        setBackground(new Color(61, 41, 110));
        setPreferredSize(new Dimension(700, 500));
        initComponents();
        tempEvent();
    }

    private void tempEvent() {
    }

    private void initComponents() {
        reservationDateLabel = new JLabel("Fecha de la reserva: ");
        reservationValueLabel = new JLabel("Valor de la reserva: ");
        idEnterpriseLabel = new JLabel("Id de la empresa: ");
        idGuestLabel = new JLabel("Id del huésped: ");
        idAccomodationType = new JLabel("Id del tipo de acomodación: ");
        idRecepcionistLabel = new JLabel("Id del recepcionista: ");
        guestCommentsLabel = new JLabel("Comentarios del huésped: ");
        reservationDatePickerPanel = new DatePickerPanel();
        reservationValueTextField = new JTextField();
        idEnterpriseTextField = new JTextField();
        idGuestTextField = new JTextField();
        idAccomodationTypeTextField = new JTextField();
        idRecepcionistTextField = new JTextField();
        guestCommentsTextArea = new JTextArea(5, 20);
        saveButton = new JButton("Guardar");
        addComponents();
    }

    private void addComponents() {
        addTitleLabel();
        addReservationDateLabel();
        addReservationDatePickerPanel();
        addReservationValueLabel();
        addReservationValueTextField();
        addIdEnterpriseLabel();
        addIdEnterpriseTextField();
        addIdGuestLabel();
        addIdGuestTextField();
        addIdAccommodationType();
        addIdAccommodationTypeTextField();
        addIdReceptionistLabel();
        addIdReceptionistTextField();
        addGuestCommentsLabel();
        addGuestCommentsTextArea();
        addSaveButton();
    }

    private void addTitleLabel() {
        JLabel titleLabel = createLabel("Registro de reservas", 30);
        GridBagConstraints gbc = createConstraints(0, 0, 2, GridBagConstraints.NORTH, new Insets(5, 0, 20, 0));
        add(titleLabel, gbc);
    }

    private void setLabelProperties(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.white);
    }

    private void textFieldsProperties(JTextField textField) {
        textField.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
    }

    private void addReservationDateLabel() {
        setLabelProperties(reservationDateLabel);
        GridBagConstraints gbc = createConstraints(0, 1, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(reservationDateLabel, gbc);
    }

    private void addReservationDatePickerPanel() {
        reservationDatePickerPanel.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));
        reservationDatePickerPanel.setBackground(new Color(61, 41, 110));
        GridBagConstraints gbc = createConstraints(1, 1, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(reservationDatePickerPanel, gbc);
    }

    private void addReservationValueLabel() {
        setLabelProperties(reservationValueLabel);
        GridBagConstraints gbc = createConstraints(0, 2, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(reservationValueLabel, gbc);
    }

    private void addReservationValueTextField() {
        textFieldsProperties(reservationValueTextField);
        GridBagConstraints gbc = createConstraints(1, 2, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(reservationValueTextField, gbc);
    }

    public void addIdEnterpriseLabel() {
        setLabelProperties(idEnterpriseLabel);
        GridBagConstraints gbc = createConstraints(0, 3, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idEnterpriseLabel, gbc);
    }

    public void addIdEnterpriseTextField() {
        textFieldsProperties(idEnterpriseTextField);
        GridBagConstraints gbc = createConstraints(1, 3, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idEnterpriseTextField, gbc);
    }

    public void addIdGuestLabel() {
        setLabelProperties(idGuestLabel);
        GridBagConstraints gbc = createConstraints(0, 4, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idGuestLabel, gbc);
    }

    public void addIdGuestTextField() {
        textFieldsProperties(idGuestTextField);
        GridBagConstraints gbc = createConstraints(1, 4, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idGuestTextField, gbc);
    }

    public void addIdAccommodationType() {
        setLabelProperties(idAccomodationType);
        GridBagConstraints gbc = createConstraints(0, 5, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idAccomodationType, gbc);
    }
    public void addIdAccommodationTypeTextField() {
        textFieldsProperties(idAccomodationTypeTextField);
        GridBagConstraints gbc = createConstraints(1, 5, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idAccomodationTypeTextField, gbc);
    }
    public void addIdReceptionistLabel() {
        setLabelProperties(idRecepcionistLabel);
        GridBagConstraints gbc = createConstraints(0, 6, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idRecepcionistLabel, gbc);
    }
    public void addIdReceptionistTextField() {
        textFieldsProperties(idRecepcionistTextField);
        GridBagConstraints gbc = createConstraints(1, 6, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idRecepcionistTextField, gbc);
    }
    public void addGuestCommentsLabel() {
        setLabelProperties(guestCommentsLabel);
        GridBagConstraints gbc = createConstraints(0, 7, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(guestCommentsLabel, gbc);
    }

    public void addGuestCommentsTextArea() {
        guestCommentsTextArea.setLineWrap(true);
        guestCommentsTextArea.setPreferredSize(new Dimension(COMPONENT_WIDTH * 2, COMPONENT_HEIGHT * 5 / 2));
        guestCommentsTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        GridBagConstraints gbc = createConstraints(1, 7, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(guestCommentsTextArea, gbc);
    }

    private void addSaveButton() {
        saveButton.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));
        saveButton.setFont(new Font("Arial", Font.BOLD, 20));
        GridBagConstraints gbc = createConstraints(0, 10, 2, GridBagConstraints.CENTER, new Insets(20, 0, 5, 0));
        add(saveButton, gbc);
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setForeground(Color.white);
        return label;
    }

    private GridBagConstraints createConstraints(int gridx, int gridy, int width, int anchor, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = width;
        gbc.anchor = anchor;
        gbc.insets = insets;
        return gbc;
    }
}
