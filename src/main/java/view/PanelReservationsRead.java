package view;

import pojo.ReservasEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class PanelReservationsRead extends JPanel {
    private JLabel titleLabel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable reservationsTable;
    private List<ReservasEntity> reservations;

    public PanelReservationsRead() {
        setLayout(new GridBagLayout());
        setBackground(new Color(61, 41, 110));
        setPreferredSize(new Dimension(1000, 500));
        initComponents();
        fillReservationsTable();
        tableEvents();
    }

    private void initComponents() {
        titleLabel = new JLabel("Reservas");
        searchTextField = new JTextField(20);
        searchButton = new JButton("Buscar");
        reservationsTable = new JTable();
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

    private void fillReservationsTable() {
        reservations = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            ReservasEntity reserva = new ReservasEntity();
            reserva.setIdReserva(i);
            reserva.setFechaReserva(Date.valueOf("2021-05-05"));
            reserva.setValorReserva(100000);
            reserva.setIdEmpresa(1);
            reserva.setIdPersonaHuesped(1);
            reserva.setIdTipoAcomodacion(1);
            reserva.setIdPersonaRecepcionista(1);
            reserva.setObservacionesHuespedHotel(i == 0 ? "Comentario 1234567890 lfaksjdlfjalks ajsdfljasl" : "Lore ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget aliquam aliquam, nisl nisl aliquet nisl, quis aliquam nisl nisl eget nisl.");
            reservations.add(reserva);
        }
        for (int i = 0; i < reservations.size() - 1; i++) {
            ReservasEntity reserve = reservations.get(i);
            ((DefaultTableModel) reservationsTable.getModel()).addRow(new Object[]{
                    reserve.getIdReserva(),
                    reserve.getFechaReserva(),
                    reserve.getValorReserva(),
                    reserve.getIdEmpresa(),
                    reserve.getIdPersonaHuesped(),
                    reserve.getIdTipoAcomodacion(),
                    reserve.getIdPersonaRecepcionista(),
                    reserve.getObservacionesHuespedHotel()
            });
        }
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
}