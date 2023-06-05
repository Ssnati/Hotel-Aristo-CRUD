package view;

import pojo.EmpresasEntity;
import pojo.PersonasEntity;
import pojo.TiposAcomodacionEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class AddReservationsPanel extends JPanel {
    private final ActionListener actionListener;
    private JLabel reservationDateLabel;
    private JLabel reservationValueLabel;
    private JLabel idEnterpriseLabel;
    private JLabel idGuestLabel;
    private JLabel idAccomodationType;
    private JLabel idRecepcionistLabel;
    private JLabel guestCommentsLabel;
    private JTextField reservationValueTextField;
    private JComboBox<String> idEnterpriseComboBox;
    private JComboBox<String> idGuestComboBox;
    private JComboBox<String> idAccomodationTypeComboBox;
    private JComboBox<String> idRecepcionistComboBox;
    private JTextArea guestCommentsTextArea;
    private DatePickerPanel reservationDatePickerPanel;
    private JButton saveButton;
    private final int COMPONENT_WIDTH = 212;
    private final int COMPONENT_HEIGHT = 35;

    public AddReservationsPanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        setLayout(new GridBagLayout());
        setBackground(new Color(61, 41, 110));
        setPreferredSize(new Dimension(700, 500));
        initComponents();
        tempEvent();
    }

    private void tempEvent() {
        saveButton.addActionListener(actionListener);
    }

    private void initComponents() {
        reservationDateLabel = new JLabel("Fecha de la reserva: ");
        reservationValueLabel = new JLabel("Valor de la reserva: ");
        idEnterpriseLabel = new JLabel("Empresa a la que se reservo: ");
        idGuestLabel = new JLabel("Huésped reservado: ");
        idAccomodationType = new JLabel("Tipo de acomodación: ");
        idRecepcionistLabel = new JLabel("Recepcionista: ");
        guestCommentsLabel = new JLabel("Comentarios del huésped: ");
        reservationDatePickerPanel = new DatePickerPanel();
        reservationValueTextField = new JTextField();
        idEnterpriseComboBox = new JComboBox<>();
        idGuestComboBox = new JComboBox<>();
        idAccomodationTypeComboBox = new JComboBox<>();
        idRecepcionistComboBox = new JComboBox<>();
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
        addIdEnterpriseComboBox();
        addIdGuestLabel();
        addIdGuestComboBox();
        addIdAccommodationType();
        addIdAccommodationTypeComboBox();
        addIdReceptionistLabel();
        addIdReceptionistComboBox();
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
        reservationValueTextField.setEnabled(false);
        GridBagConstraints gbc = createConstraints(1, 2, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(reservationValueTextField, gbc);
    }

    public void addIdEnterpriseLabel() {
        setLabelProperties(idEnterpriseLabel);
        GridBagConstraints gbc = createConstraints(0, 3, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idEnterpriseLabel, gbc);
    }

    public void addIdEnterpriseComboBox() {
        textFieldsProperties(idEnterpriseComboBox);
        GridBagConstraints gbc = createConstraints(1, 3, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idEnterpriseComboBox, gbc);
    }

    private void textFieldsProperties(JComboBox<String> comboBox) {
        comboBox.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));
        comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
    }

    public void addIdGuestLabel() {
        setLabelProperties(idGuestLabel);
        GridBagConstraints gbc = createConstraints(0, 4, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idGuestLabel, gbc);
    }

    public void addIdGuestComboBox() {
        textFieldsProperties(idGuestComboBox);
        GridBagConstraints gbc = createConstraints(1, 4, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idGuestComboBox, gbc);
    }

    public void addIdAccommodationType() {
        setLabelProperties(idAccomodationType);
        GridBagConstraints gbc = createConstraints(0, 5, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idAccomodationType, gbc);
    }

    public void addIdAccommodationTypeComboBox() {
        textFieldsProperties(idAccomodationTypeComboBox);
        GridBagConstraints gbc = createConstraints(1, 5, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idAccomodationTypeComboBox, gbc);
    }

    public void addIdReceptionistLabel() {
        setLabelProperties(idRecepcionistLabel);
        GridBagConstraints gbc = createConstraints(0, 6, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(idRecepcionistLabel, gbc);
    }

    public void addIdReceptionistComboBox() {
        textFieldsProperties(idRecepcionistComboBox);
        GridBagConstraints gbc = createConstraints(1, 6, 1, GridBagConstraints.WEST, new Insets(5, 0, 5, 0));
        add(idRecepcionistComboBox, gbc);
    }

    public void addGuestCommentsLabel() {
        setLabelProperties(guestCommentsLabel);
        GridBagConstraints gbc = createConstraints(0, 7, 1, GridBagConstraints.EAST, new Insets(5, 0, 5, 0));
        add(guestCommentsLabel, gbc);
    }

    public void addGuestCommentsTextArea() {
        guestCommentsTextArea.setLineWrap(true);
        guestCommentsTextArea.setWrapStyleWord(true);
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

    public void loadData(List<PersonasEntity> personas, List<TiposAcomodacionEntity> tiposAcomodacion, List<EmpresasEntity> empresas) {
        idGuestComboBox.removeAllItems();
        idEnterpriseComboBox.removeAllItems();
        idAccomodationTypeComboBox.removeAllItems();
        idRecepcionistComboBox.removeAllItems();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("COP"));
        for (PersonasEntity persona : personas) {
            idGuestComboBox.addItem(persona.getNombrePersona());
            idRecepcionistComboBox.addItem(persona.getNombrePersona());
        }
        for (TiposAcomodacionEntity tipoAcomodacion : tiposAcomodacion) {
            idAccomodationTypeComboBox.addItem("<html><br>" + tipoAcomodacion.getNombreTipoAcomodacion() + " <br>" + formatter.format(tipoAcomodacion.getPrecioAcomodacion()) + "<br></html>");
        }
        for (EmpresasEntity empresa : empresas) {
            idEnterpriseComboBox.addItem(empresa.getNombreEmpresa());
        }
    }
}
