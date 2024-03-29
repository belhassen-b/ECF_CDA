package com.example.views;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AdminUI extends JFrame {

    public AdminUI() {
        super();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Administration");
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2));

        JButton crudReservationButton = new JButton("Reservations");
        ImageIcon crudReservationIcon = new ImageIcon(Objects.requireNonNull(AdminUI.class.getResource("/images/crudIcon/reservation.png")));
        crudReservationIcon.setImage(crudReservationIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        crudReservationButton.setIcon(crudReservationIcon);

        JButton crudUserButton = new JButton("Users");
        ImageIcon crudUserIcon = new ImageIcon(Objects.requireNonNull(AdminUI.class.getResource("/images/crudIcon/user.png")));
        crudUserIcon.setImage(crudUserIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        crudUserButton.setIcon(crudUserIcon);

        JButton crudEstimationButton = new JButton("Estimations");
        ImageIcon crudEstimationIcon = new ImageIcon(Objects.requireNonNull(AdminUI.class.getResource("/images/crudIcon/ratings.png")));
        crudEstimationIcon.setImage(crudEstimationIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        crudEstimationButton.setIcon(crudEstimationIcon);

        JButton crudStatisticsButton = new JButton("Statistics");
        ImageIcon crudStatisticsIcon = new ImageIcon(Objects.requireNonNull(AdminUI.class.getResource("/images/crudIcon/Statistics.png")));
        crudStatisticsIcon.setImage(crudStatisticsIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        crudStatisticsButton.setIcon(crudStatisticsIcon);


        panel.add(crudReservationButton);
        panel.add(crudUserButton);
        panel.add(crudEstimationButton);
        panel.add(crudStatisticsButton);

        setContentPane(panel);

        crudReservationButton.addActionListener(e -> new ReservationUI());
        crudUserButton.addActionListener(e -> {
            try {
                new UserUI();
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        });
        crudEstimationButton.addActionListener(e -> new EstimationUI());
        crudStatisticsButton.addActionListener(e -> new StatisticsUI());

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminUI();
    }
}
