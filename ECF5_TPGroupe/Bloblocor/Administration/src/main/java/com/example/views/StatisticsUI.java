package com.example.views;



import com.example.service.ObservationService;
import com.example.service.ReservationService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StatisticsUI extends JFrame {


    private JTable statisticsTable;
    private JTextField searchTextField;

    public StatisticsUI() {
        super("Statistics");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("Search by User ID:");

        mainPanel.setLayout(new BorderLayout());
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(searchLabel);

        searchTextField = new JTextField(10);
        searchPanel.add(searchTextField);

        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        JButton backBtn = new JButton("Back");
        backBtn.setBackground(Color.RED);
        backBtn.setForeground(Color.WHITE);
        backBtn.setPreferredSize(new Dimension(100, 40));

        backBtn.addActionListener(e -> {
            new AdminUI();
            dispose();
        });
        searchPanel.add(backBtn);


        mainPanel.add(searchPanel, BorderLayout.NORTH);

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{
                        {"", "", "", "", ""},
                },
                new String[]{
                        "Id User", "ReservationCount", "Top Rating", "Low Rating", "Average Rating"
                }
        );
        statisticsTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(statisticsTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(mainPanel);

        searchButton.addActionListener(e -> addDataToTable());

        addDataToTable();

        setVisible(true);
    }
    private void addDataToTable() {
        ReservationService reservation = new ReservationService();
        ObservationService observation = new ObservationService();

        DefaultTableModel tableModel = (DefaultTableModel) statisticsTable.getModel();
        tableModel.setRowCount(0);
        String userId = searchTextField.getText().trim();

        if (!userId.isEmpty()) {
            try {
                long userIdLong = Long.parseLong(userId);
                int reservationCount = reservation.getReservationCount((int) userIdLong);

                if( reservationCount == 0){
                    JOptionPane.showMessageDialog(this, "User has no reservations", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


//                int topRating = observation.getTopRatingByUserId(userIdLong);
//                int lowRating = observation.getLowRatingByUserId(userIdLong);
//                int averageRating = (int) observation.getAverageRatingByUserId(userIdLong);

                Object[] rowData = {userId, reservationCount, "", "", ""};
                tableModel.addRow(rowData);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid User ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(StatisticsUI::new);
    }
}
