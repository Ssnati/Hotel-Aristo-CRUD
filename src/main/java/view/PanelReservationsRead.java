package view;

import pojo.ReserveFullData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;


public class PanelReservationsRead extends JPanel {
    private final ActionListener actionListener;
    private JLabel titleLabel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable reservationsTable;
    private JButton deleteButton;

    public PanelReservationsRead(ActionListener actionListener) {
        this.actionListener = actionListener;
        setLayout(new GridBagLayout());
        setBackground(new Color(61, 41, 110));
        setPreferredSize(new Dimension(1000, 500));
        initComponents();
        tableEvents();
        searchEvents();
    }

    private void searchEvents() {
        searchButton.addActionListener(actionListener);
        searchTextField.addActionListener(actionListener);
        searchButton.setActionCommand("search");
        searchTextField.setActionCommand("search");
        deleteButton.addActionListener(actionListener);
        deleteButton.setActionCommand("delete");
    }

    private void initComponents() {
        titleLabel = new JLabel("Reservas");
        searchTextField = new JTextField(20);
        searchButton = new JButton("Buscar");
        reservationsTable = new JTable();
        deleteButton = new JButton("Eliminar");
        performTableSettings();

        addComponents();
    }

    private void tableEvents() {
        reservationsTable.getColumnModel().getColumn(7).setCellRenderer(new LongTextRenderer());
        reservationsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = reservationsTable.rowAtPoint(e.getPoint());
                int column = reservationsTable.columnAtPoint(e.getPoint());
                if (column == 7 && reservationsTable.getValueAt(row, column) instanceof String longText) {
                    showLongTextDialog(longText);
                }
            }
        });
    }

    private void showLongTextDialog(String longText) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Comentarios del huésped");
        dialog.setModal(true);

        JTextArea textArea = new JTextArea(longText);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.BOLD, 15));

        dialog.getContentPane().add(textArea);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void performTableSettings() {
        reservationsTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Id reserva", "Fecha reserva", "Valor reserva", "Empresa", "Huésped", "Tipo de acomodación", "Recepcionista", "Comentarios del huésped"})
        );
        reservationsTable.setRowHeight(30);
        reservationsTable.getTableHeader().setReorderingAllowed(false);
        reservationsTable.getTableHeader().setResizingAllowed(false);
        reservationsTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        reservationsTable.getColumnModel().getColumn(1).setPreferredWidth(40);
    }

    private void addComponents() {
        addTitleLabel();
        addSearchButton();
        addSearchTextField();
        addReservationsTable();
        addDeleteButton();
    }

    private void addTitleLabel() {
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        add(titleLabel, gbc);
    }

    private void addSearchButton() {
        searchButton.setPreferredSize(new Dimension(100, 30));
        searchButton.setFont(new Font("Arial", Font.BOLD, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 20, 0);
        add(searchButton, gbc);
    }

    private void addSearchTextField() {
        searchTextField.setPreferredSize(new Dimension(200, 30));
        searchTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        int width = searchTextField.getPreferredSize().width + searchButton.getPreferredSize().width;
        int middle = (getPreferredSize().width - width) / 2;
        int definitiveWidth = middle - 50;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, definitiveWidth, 20, 0);
        add(searchTextField, gbc);
    }

    private void addReservationsTable() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        JScrollPane scrollPane = new JScrollPane(reservationsTable);
        scrollPane.setPreferredSize(new Dimension(getPreferredSize().width - 100, 300));
        add(scrollPane, gbc);
    }

    private void addDeleteButton() {
        deleteButton.setPreferredSize(new Dimension(100, 30));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 20, 0);
        add(deleteButton, gbc);
    }

    public void loadData(List<ReserveFullData> reservas) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("COP"));
        ((DefaultTableModel) reservationsTable.getModel()).setRowCount(0);
        for (ReserveFullData reserva : reservas) {
            ((DefaultTableModel) reservationsTable.getModel()).addRow(new Object[]{
                    reserva.getIdReserve(),
                    reserva.getReserveDate(),
                    formatter.format(reserva.getReserveValue()),
                    reserva.getBookingCompanyName(),
                    reserva.getGuestName(),
                    reserva.getAcomodateTypeName(),
                    reserva.getReceptionistName(),
                    reserva.getReserveObservations()
            });
        }
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public void setSearchTextField(JTextField searchTextField) {
        this.searchTextField = searchTextField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JTable getReservationsTable() {
        return reservationsTable;
    }

    public void setReservationsTable(JTable reservationsTable) {
        this.reservationsTable = reservationsTable;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
}