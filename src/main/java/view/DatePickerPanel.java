package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DatePickerPanel extends JPanel {
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;

    public DatePickerPanel() {
        initComponents();
        setDate(LocalDate.now());
    }

    public DatePickerPanel(int day, int month, int year) {
        initComponents();
        dayComboBox.setSelectedIndex(day - 1);
        monthComboBox.setSelectedIndex(month - 1);
        yearComboBox.setSelectedIndex(year - 1900);
    }

    public DatePickerPanel(Date date) {
        initComponents();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        dayComboBox.setSelectedIndex(calendar.get(Calendar.DAY_OF_MONTH) - 1);
        monthComboBox.setSelectedIndex(calendar.get(Calendar.MONTH));
        yearComboBox.setSelectedItem(calendar.get(Calendar.YEAR));
    }

    public DatePickerPanel(LocalDate date) {
        initComponents();
        dayComboBox.setSelectedIndex(date.getDayOfMonth() - 1);
        monthComboBox.setSelectedIndex(date.getMonthValue() - 1);
        yearComboBox.setSelectedIndex(date.getYear() - 1900);
    }

    private void initComponents() {
        dayComboBox = new JComboBox<>(getDays(31));
        monthComboBox = new JComboBox<>(getMonths());
        yearComboBox = new JComboBox<>(getYears());

        add(dayComboBox);
        add(monthComboBox);
        add(yearComboBox);

        changeDayByMonth();
    }

    private void changeDayByMonth() {
        ActionListener updateDayComboBoxAction = e -> {
            int month = monthComboBox.getSelectedIndex();
            int year = yearComboBox.getSelectedIndex();
            int days = getDaysInMonth(month, year);
            updateDayComboBox(days);
        };

        monthComboBox.addActionListener(updateDayComboBoxAction);
        yearComboBox.addActionListener(updateDayComboBoxAction);
    }

    private int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 0, 2, 4, 6, 7, 9, 11 -> 31;
            case 1 -> isLeapYear(year) ? 29 : 28;
            default -> 30;
        };
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private void updateDayComboBox(int days) {
        int day = dayComboBox.getSelectedIndex();
        dayComboBox.removeAllItems();
        dayComboBox.setModel(new DefaultComboBoxModel<>(getDays(days)));
        dayComboBox.setSelectedIndex(day < days ? day : days - 1);
    }


    private String[] getDays(int days) {
        String[] daysArray = new String[days];
        for (int i = 0; i < days; i++) {
            daysArray[i] = String.format("%02d", i + 1);
        }
        return daysArray;
    }

    private String[] getMonths() {
        return new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    }

    private String[] getYears() {
        String[] years = new String[200];
        for (int i = 0; i < 200; i++) {
            years[i] = String.valueOf(1900 + i);
        }
        return years;
    }

    public Date getDate() {
        int day = dayComboBox.getSelectedIndex() + 1;
        int month = monthComboBox.getSelectedIndex() + 1;
        int year = yearComboBox.getSelectedIndex() + 1900;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        return calendar.getTime();
    }

    public LocalDate getLocalDate() {
        int day = dayComboBox.getSelectedIndex() + 1;
        int month = monthComboBox.getSelectedIndex() + 1;
        int year = yearComboBox.getSelectedIndex() + 1900;
        return LocalDate.of(year, month, day);
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        dayComboBox.setSelectedIndex(calendar.get(Calendar.DAY_OF_MONTH) - 1);
        monthComboBox.setSelectedIndex(calendar.get(Calendar.MONTH));
        yearComboBox.setSelectedItem(calendar.get(Calendar.YEAR));
    }

    public void setDate(LocalDate date) {
        dayComboBox.setSelectedIndex(date.getDayOfMonth() - 1);
        monthComboBox.setSelectedIndex(date.getMonthValue() - 1);
        yearComboBox.setSelectedIndex(date.getYear() - 1900);
    }
}
