package com.example.views;


import com.example.dto.observation.ResponseObservationDTO;
import com.example.service.ObservationService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

public class EstimationUI extends JFrame {


    private ObservationService observationService = new ObservationService();


    private JTable estimationTable;

    public EstimationUI() {

        super("Observations");
        initComponents();
        showAllObservations();

    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        JPanel searchPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());

        JPanel tablePanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        tablePanel.setLayout(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{{"", "", "", "", "", ""}},
                new String[]{ "Notation", "Comment", "isEnded", "IdClient", "IdDriver", "IdReservation"}
        );

        estimationTable = new JTable(tableModel);
        estimationTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        estimationTable.setRowHeight(30);
        estimationTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(estimationTable);
        scrollPane.setPreferredSize(new Dimension(700, 300));

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        buttonsPanel.setLayout(new FlowLayout());

        ImageIcon deleteIcon = new ImageIcon(Objects.requireNonNull(EstimationUI.class.getResource("/images/delete.png")));
        deleteIcon.setImage(deleteIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton deleteEstimationButton = new JButton("Delete", deleteIcon);
        deleteEstimationButton.setPreferredSize(new Dimension(200, 40));

        JButton backBtn = new JButton("Back");
        backBtn.setBackground(Color.RED);
        backBtn.setForeground(Color.WHITE);
        backBtn.setPreferredSize(new Dimension(100, 40));

addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = estimationTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Object value = estimationTable.getValueAt(selectedRow, 0);
                    String id = value.toString();
                    String responseObservationDTO = observationService.getById(id);
                    if (responseObservationDTO != null) {
                        observationService.delete(id);
                        JOptionPane.showMessageDialog(null, "Le commentaire a été supprimé");
                    } else {
                        JOptionPane.showMessageDialog(null, "Commentaire introuvable");
                    }
                }
            }
        });



        deleteEstimationButton.addActionListener(e -> {
            int selectedRow = estimationTable.getSelectedRow();
            Object value = estimationTable.getValueAt(selectedRow, 0);
            String id = value.toString();
            String responseObservationDTO = observationService.getById(id);

            if (responseObservationDTO != null) {
                observationService.delete(id);
                JOptionPane.showMessageDialog(null, "Le commentaire a été supprimé");
            } else {
                JOptionPane.showMessageDialog(null, "Commentaire introuvable");
            }
        });

        backBtn.addActionListener(e -> {
            new AdminUI();
            dispose();
        });


        buttonsPanel.add(deleteEstimationButton);
        buttonsPanel.add(backBtn);

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);


        backBtn.addActionListener(e -> {
            new AdminUI();
            dispose();
        });

        setVisible(true);
    }

    private void showAllObservations() {
        observationService = new ObservationService();
        List<ResponseObservationDTO> observations = observationService.getAll();
        DefaultTableModel tableModel = (DefaultTableModel) estimationTable.getModel();
        tableModel.setRowCount(0);

        for (ResponseObservationDTO observation : observations) {
            Object[] rowData = {
                    observation.getNotation(),
                    observation.getComment(),
                    observation.isEnded(),
                    observation.getIdClient(),
                    observation.getIdDriver(),
                    observation.getIdReservation()
            };
            tableModel.addRow(rowData);
        }
        System.out.println("Observations: " + observations);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(EstimationUI::new);
    }

}
