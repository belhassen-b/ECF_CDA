package com.example.views;


import com.example.dto.reservation.RequestReservationDTO;
import com.example.dto.reservation.ResponseReservationDTO;
import com.example.dto.reservation.ResponseTakeReservationDTO;
import com.example.model.RightReservationTableModel;
import com.example.service.ReservationService;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

public class ReservationUI extends JFrame {

    private final RightReservationTableModel model;

    private ReservationService reservationService = new ReservationService();

    public ReservationUI() {
        super();
        model = new RightReservationTableModel((new ArrayList<>()));

        initComponents();
    }

    public void initComponents() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Reservations");
        setSize(1024, 768);
        setResizable(true);
        setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);


        JLabel reservationIdLabel = new JLabel("Reservation ID");
        JLabel departureLabel = new JLabel("Departure");
        JLabel arrivalLabel = new JLabel("Arrival");
        JLabel dateLabel = new JLabel("Date");
        JDateChooser dateChooser = new JDateChooser();
        JLabel priceLabel = new JLabel("Price");
        JLabel clientIdLabel = new JLabel("Client ID");
        JLabel driverIdLabel = new JLabel("Driver ID");
        JLabel estimationIdLabel = new JLabel("Estimation ID");

        reservationIdLabel.setBounds(20, 20, 100, 25);
        departureLabel.setBounds(20, 50, 100, 25);
        arrivalLabel.setBounds(20, 80, 100, 25);
        dateLabel.setBounds(20, 110, 100, 25);
        priceLabel.setBounds(20, 140, 100, 25);
        driverIdLabel.setBounds(20, 170, 100, 25);
        clientIdLabel.setBounds(20, 200, 100, 25);
        estimationIdLabel.setBounds(20, 230, 100, 25);


        panel1.add(reservationIdLabel);
        panel1.add(departureLabel);
        panel1.add(arrivalLabel);
        panel1.add(dateLabel);
        panel1.add(dateChooser);
        panel1.add(priceLabel);
        panel1.add(driverIdLabel);
        panel1.add(clientIdLabel);
        panel1.add(estimationIdLabel);


        JTextField reservationIdTxtField = new JTextField();
        JTextField departureTxtField = new JTextField();
        JTextField arrivalTxtField = new JTextField();
        JTextField dateTxtField = new JTextField();
        JTextField priceTxtField = new JTextField();
        JTextField clientIdTxtField = new JTextField();
        JTextField driverIdTxtField = new JTextField();
        JTextField estimationIdTxtField = new JTextField();


        ImageIcon addReservationButtonIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/floppy.png")));
        addReservationButtonIcon.setImage(addReservationButtonIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_DEFAULT));
        JButton addReservationButton = new JButton("Add", addReservationButtonIcon);

        ImageIcon updateReservationButtonIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/pen.png")));
        updateReservationButtonIcon.setImage(updateReservationButtonIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton updateReservationButton = new JButton("Update", updateReservationButtonIcon);


        ImageIcon deleteReservationButtonIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/delete.png")));
        deleteReservationButtonIcon.setImage(deleteReservationButtonIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton deleteReservationButton = new JButton("Delete", deleteReservationButtonIcon);

        JTable reservationTable = new JTable();
        JScrollPane reservationScrollPane = new JScrollPane();


        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.white);

        reservationIdTxtField.setBounds(230, 20, 200, 25);
        reservationIdTxtField.setEditable(false);
        reservationIdTxtField.setBackground(new java.awt.Color(204, 204, 204));
        departureTxtField.setBounds(230, 50, 200, 25);
        arrivalTxtField.setBounds(230, 80, 200, 25);
        dateChooser.setBounds(230, 110, 200, 25);
        dateChooser.addPropertyChangeListener("date", e -> {
                    if (e.getNewValue() != null) {
                        java.util.Date selectedDate = dateChooser.getDate();
                        dateTxtField.setText(new Date(selectedDate.getTime()).toString());
                    }
                }
        );
        priceTxtField.setBounds(230, 140, 200, 25);
        driverIdTxtField.setBounds(230, 170, 200, 25);
        clientIdTxtField.setBounds(230, 200, 200, 25);
        estimationIdTxtField.setBounds(230, 230, 200, 25);


        addReservationButton.setBounds(20, 400, 200, 25);
        updateReservationButton.setBounds(230, 400, 200, 25);
        deleteReservationButton.setBounds(20, 450, 410, 25);

        reservationScrollPane.setBounds(450, 30, 550, 700);
        reservationScrollPane.setViewportView(reservationTable);

        backButton.setBounds(20, 500, 410, 25);

        panel1.add(reservationIdTxtField);
        panel1.add(departureTxtField);
        panel1.add(arrivalTxtField);
        panel1.add(dateTxtField);
        panel1.add(priceTxtField);
        panel1.add(driverIdTxtField);
        panel1.add(clientIdTxtField);
        panel1.add(estimationIdTxtField);

        panel1.add(addReservationButton);
        panel1.add(updateReservationButton);
        panel1.add(deleteReservationButton);

        panel1.add(reservationScrollPane);

        panel1.add(backButton);

        setContentPane(panel1);

        reservationTable.setModel(model);
        reservationTable.setAutoCreateRowSorter(true);
        reservationTable.setPreferredSize(new java.awt.Dimension(900, 700));
        reservationScrollPane.setViewportView(reservationTable);
        reservationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                super.mouseClicked(evt);
                int selectedRow = reservationTable.getSelectedRow();
                if (selectedRow >= 0) {
                    reservationIdTxtField.setText(reservationTable.getValueAt(selectedRow, 0).toString());
                    departureTxtField.setText(reservationTable.getValueAt(selectedRow, 1).toString());
                    arrivalTxtField.setText(reservationTable.getValueAt(selectedRow, 2).toString());
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = dateFormat.parse(reservationTable.getValueAt(selectedRow, 3).toString());
                        dateChooser.setDate(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    priceTxtField.setText(reservationTable.getValueAt(selectedRow, 4).toString());
                    clientIdTxtField.setText(reservationTable.getValueAt(selectedRow, 5).toString());
                    driverIdTxtField.setText(reservationTable.getValueAt(selectedRow, 6).toString());
                    estimationIdTxtField.setText(reservationTable.getValueAt(selectedRow, 7).toString());

                }

            }
        });

        showReservations(reservationTable);
        setVisible(true);


        backButton.addActionListener(e -> {
            new AdminUI();
            dispose();
        });

        // button listener
        addReservationButton.addActionListener(e -> {
            RequestReservationDTO reservation = new RequestReservationDTO().builder()
                    .departure(departureTxtField.getText())
                    .arrival(arrivalTxtField.getText())
                    .date(String.valueOf(new Date(dateChooser.getDate().getTime())))
                    .price(Double.valueOf(priceTxtField.getText()))
                    .clientId(Long.parseLong(clientIdTxtField.getText()))
                    .driverId(Long.parseLong(driverIdTxtField.getText()))
                    .estimationId(Long.parseLong(estimationIdTxtField.getText()))
                    .build();
            ResponseReservationDTO responseReservationDTO = reservationService.add(reservation);
            if (responseReservationDTO != null) {
                JOptionPane.showMessageDialog(null, "Reservation added successfully!");
                dispose();
                new ReservationUI();
            } else {
                JOptionPane.showMessageDialog(null, "Reservation not added!");
            }

        });
        updateReservationButton.addActionListener(e -> {
            RequestReservationDTO reservation = new RequestReservationDTO().builder()
                    .id(Long.parseLong(reservationIdTxtField.getText()))
                    .departure(departureTxtField.getText())
                    .arrival(arrivalTxtField.getText())
                    .date(String.valueOf(new Date(dateChooser.getDate().getTime())))
                    .price(Double.valueOf(priceTxtField.getText()))
                    .clientId(Long.parseLong(clientIdTxtField.getText()))
                    .driverId(Long.parseLong(driverIdTxtField.getText()))
                    .estimationId(Long.parseLong(estimationIdTxtField.getText()))
                    .build();
            if (reservationService.update(reservation) != null) {
                JOptionPane.showMessageDialog(null, "Reservation updated successfully!");
                dispose();
                new ReservationUI();
            } else {
                JOptionPane.showMessageDialog(null, "Reservation not updated!");
            }
        });

        deleteReservationButton.addActionListener(e -> {
                    ResponseTakeReservationDTO responseTakeReservationDTO = reservationService.getByIdTake((int) Long.parseLong(reservationIdTxtField.getText()));
                    if (responseTakeReservationDTO != null) {
                        reservationService.delete(responseTakeReservationDTO.getId());
                        JOptionPane.showMessageDialog(null, "Reservation deleted successfully!");
                        dispose();
                        new ReservationUI();
                    } else {
                        JOptionPane.showMessageDialog(null, "Reservation not deleted!");
                    }
                }
        );

    }


    private void showReservations(JTable reservationTable) {
        reservationService = new ReservationService();
        ResponseReservationDTO reservations = reservationService.getAll();
        RightReservationTableModel model = new RightReservationTableModel(reservations.getReservations());
        reservationTable.setModel(model);
        reservationTable.repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReservationUI::new);
    }


}
