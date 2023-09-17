package com.example.views;


import com.example.dto.utilisateur.RequestUtilisateurDTO;
import com.example.dto.utilisateur.ResponseUtilisateurDTO;
import com.example.model.BottomUserTableModel;
import com.example.service.ObservationService;
import com.example.service.ReservationService;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserUI extends JFrame {

    private final JFileChooser fileChooser = new JFileChooser();

    private final BottomUserTableModel model;

    private JTextField txtId;

    private JTextField txtLastName;

    private JTextField txtFirstName;

    private JTextField txtEmail;

    private JTextField txtPhone;

    private JTextField txtIsDriver;

    private JTextField txtReservations;

    private JTextField txtEstimations;


    private JRadioButton isAdmin;

    private JRadioButton isUser;
    private JTable table;

    private UserService userService;


    public UserUI() throws JsonProcessingException {
        super();

        model = new BottomUserTableModel(new ArrayList<>());
        initComponents();

    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interface administrateur");
        setSize(1024, 900);
        setResizable(false);
        setLocationRelativeTo(null);

        table = new JTable();

        JPanel contentPanel = new JPanel(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        contentPanel.add(mainPanel, BorderLayout.CENTER);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setPreferredSize(new Dimension(200, 400));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setFont(new Font("Arial", Font.PLAIN, 20));
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setPreferredSize(new Dimension(200, 400));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setFont(new Font("Arial", Font.PLAIN, 40));
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        headerPanel.setPreferredSize(new Dimension(1024, 300));
        headerPanel.setLayout(null);
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));


        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBounds(200, 0, 780, 40);
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBounds(0, 0, 1024, 550);

        JLabel lblId = new JLabel("Id");
        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setBackground(Color.LIGHT_GRAY);
        lblId.setBounds(50, 15, 100, 20);
        txtId.setBounds(150, 15, 150, 20);
        txtId.setColumns(20);
        headerPanel.add(lblId);
        headerPanel.add(txtId);


        JLabel lblUserName = new JLabel("Username");
        JTextField txtUserName = new JTextField();
        lblUserName.setBounds(50, 40, 100, 20);
        txtUserName.setBounds(150, 40, 150, 20);
        txtUserName.setColumns(20);
        headerPanel.add(lblUserName);
        headerPanel.add(txtUserName);



        JLabel lblName = new JLabel("Lastname");
        txtLastName = new JTextField();
        lblName.setBounds(50, 65, 100, 20);
        txtLastName.setBounds(150, 65, 150, 20);
        txtLastName.setColumns(20);
        headerPanel.add(lblName);
        headerPanel.add(txtLastName);

        JLabel lblfirstname = new JLabel("Firstname");
        txtFirstName = new JTextField(2);
        lblfirstname.setBounds(50, 90, 100, 20);
        txtFirstName.setBounds(150, 90, 150, 20);
        txtFirstName.setColumns(20);

        headerPanel.add(lblfirstname);
        headerPanel.add(txtFirstName);


        JLabel lblContactNo = new JLabel("Phone");
        txtPhone = new JTextField();
        lblContactNo.setBounds(50, 115, 100, 20);
        txtPhone.setBounds(150, 115, 150, 20);
        txtPhone.setColumns(20);
        headerPanel.add(lblContactNo);
        headerPanel.add(txtPhone);

        JLabel lblEmail = new JLabel("Email");
        txtEmail = new JTextField();
           lblEmail.setBounds(50, 145, 100, 20);
        txtEmail.setBounds(150, 145, 150, 20);
        txtEmail.setColumns(20);
        headerPanel.add(lblEmail);
        headerPanel.add(txtEmail);

        JLabel lblIsDriver = new JLabel("isDriver");
        txtIsDriver = new JTextField();
        lblIsDriver.setBounds(50, 190, 100, 20);
        txtIsDriver.setBounds(150, 190, 150, 20);
        txtIsDriver.setColumns(10);
        headerPanel.add(lblIsDriver);
        headerPanel.add(txtIsDriver);

        JLabel lblIsAdmin = new JLabel("isAdmin");
        isAdmin = new JRadioButton("Admin");
        isUser = new JRadioButton("User");
        lblIsAdmin.setBounds(50, 220, 100, 20);
        isAdmin.setBounds(150, 220, 100, 20);
        isUser.setBounds(250, 220, 100, 20);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(isAdmin);
        buttonGroup.add(isUser);
        headerPanel.add(lblIsAdmin);
        headerPanel.add(isAdmin);
        headerPanel.add(isUser);


        JLabel lblReservations = new JLabel("Reservations");
        txtReservations = new JTextField();
        lblReservations.setBounds(50, 270, 100, 20);
        txtReservations.setBounds(150, 270, 150, 20);
        txtReservations.setColumns(10);
        txtReservations.setHorizontalAlignment(JTextField.CENTER);
        txtReservations.setFont(new Font("Arial", Font.PLAIN, 40));
        leftPanel.add(lblReservations);
        leftPanel.add(txtReservations);

        JLabel lblEstimations = new JLabel("Estimations");
        txtEstimations = new JTextField();
        lblEstimations.setBounds(50, 300, 100, 20);
        txtEstimations.setColumns(10);
        txtEstimations.setHorizontalAlignment(JTextField.CENTER);
        txtEstimations.setFont(new Font("Arial", Font.PLAIN, 40));
        rightPanel.add(lblEstimations);
        rightPanel.add(txtEstimations);





        ImageIcon newIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/new.png")));
        newIcon.setImage(newIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton newButton = new JButton("New", newIcon);

        centerPanel.add(newButton);


        ImageIcon saveIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/floppy.png")));
        saveIcon.setImage(saveIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton saveButton = new JButton("Save", saveIcon);
        centerPanel.add(saveButton);



        ImageIcon updateIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/pen.png")));
        updateIcon.setImage(updateIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton updateButton = new JButton("Update", updateIcon);
        centerPanel.add(updateButton);

        ImageIcon deleteIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/delete.png")));
        deleteIcon.setImage(deleteIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton deleteButton = new JButton("Delete", deleteIcon);
        centerPanel.add(deleteButton);


        ImageIcon clearIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/clear.png")));
        clearIcon.setImage(clearIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton clearButton = new JButton("Clear", clearIcon);
        centerPanel.add(clearButton);

        ImageIcon printIcon = new ImageIcon(Objects.requireNonNull(UserUI.class.getResource("/images/printer.png")));
        printIcon.setImage(printIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JButton printButton = new JButton("Print", printIcon);
        centerPanel.add(printButton);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.white);
        centerPanel.add(backButton);


        JButton btnUploadImage = new JButton("Upload Image");
        btnUploadImage.setBounds(400, 220, 200, 20);
        headerPanel.add(btnUploadImage);


        JTextField txtEmpImage = new JTextField();
        JLabel lblEmpImage = new JLabel("Image Path");
        lblEmpImage.setBounds(300, 190, 100, 20);
        txtEmpImage.setBounds(400, 190, 200, 20);
        txtEmpImage.setColumns(30);
        headerPanel.add(lblEmpImage);
        headerPanel.add(txtEmpImage);

        JLabel lblImagePreview = new JLabel();
        lblImagePreview.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        lblImagePreview.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lblImagePreview.setBackground(Color.WHITE);
        lblImagePreview.setOpaque(true);
        lblImagePreview.setHorizontalAlignment(JLabel.CENTER);
        lblImagePreview.setVerticalAlignment(JLabel.CENTER);
        lblImagePreview.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        headerPanel.add(lblImagePreview);
        lblImagePreview.setBounds(650, 80, 280, 200);


        btnUploadImage.addActionListener(e -> {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                ImageIcon imageIcon = new ImageIcon(imagePath);
                txtEmpImage.setText(imagePath);
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 250, Image.SCALE_SMOOTH));
                lblImagePreview.setIcon(imageIcon);
            }
        });


        // button listener
        newButton.addActionListener(e -> {
            txtId.setText("");
            txtUserName.setText("");
            txtLastName.setText("");
            txtFirstName.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtIsDriver.setText("");
            txtReservations.setText("");
            txtEstimations.setText("");
            deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
            printButton.setEnabled(false);
            clearButton.setEnabled(false);
            saveButton.setEnabled(true);
        });

        saveButton.addActionListener(e -> {
            RequestUtilisateurDTO requestUtilisateurDTO = RequestUtilisateurDTO.builder()
                    .username(txtUserName.getText())
                    .lastname(txtLastName.getText())
                    .firstname(txtFirstName.getText())
                    .email(txtEmail.getText())
                    .phone(txtPhone.getText())
                    .isAdmin(isAdmin.isSelected())
                    .isDriver(Boolean.parseBoolean(txtIsDriver.getText()))
                    .avatar(txtEmpImage.getText())
                    .build();

            ResponseUtilisateurDTO response = userService.add(requestUtilisateurDTO);
            JOptionPane.showMessageDialog(null, "L'utilisateur a bien été ajouté !", "Success", JOptionPane.INFORMATION_MESSAGE);
            showUser(table);

        });


        updateButton.addActionListener(e -> {
            RequestUtilisateurDTO requestUtilisateurDTO = RequestUtilisateurDTO.builder()
                    .id((int) Long.parseLong(txtId.getText()))
                    .username(txtUserName.getText())
                    .lastname(txtLastName.getText())
                    .firstname(txtFirstName.getText())
                    .email(txtEmail.getText())
                    .phone(txtPhone.getText())
                    .isAdmin(isAdmin.isSelected())
                    .isDriver(Boolean.parseBoolean(txtIsDriver.getText()))
                    .build();

            if (txtId != null) {
                userService.update(requestUtilisateurDTO);
            } else {
                JOptionPane.showMessageDialog(null, "UserService is not properly initialized.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "L'utilisateur a bien été modifié !", "Success", JOptionPane.INFORMATION_MESSAGE);
            showUser(table);
        });




        deleteButton.addActionListener(e -> {
            ResponseUtilisateurDTO responseUtilisateurDTO = userService.getById((int) Long.parseLong(txtId.getText()));
            if (responseUtilisateurDTO != null) {
                userService.delete(responseUtilisateurDTO.getId());
                JOptionPane.showMessageDialog(null, "L'utilisateur a bien été supprimé !", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "UserService is not properly initialized.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            showUser(table);
        });
        clearButton.addActionListener(e -> {
            newButton.doClick();
            deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
            printButton.setEnabled(false);
            clearButton.setEnabled(false);
            saveButton.setEnabled(true);
        });


        printButton.addActionListener(e -> {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new AdminUI();
        });


        table.setModel(model);
        table.setPreferredSize(new Dimension(1024, 400));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Object value = table.getValueAt(selectedRow, 7);

                    if (value != null) {
                        if (value.toString().equals("true")) {
                            isAdmin.setSelected(true);
                        } else {
                            isUser.setSelected(true);
                        }
                    }
                    txtId.setText(table.getValueAt(selectedRow, 0).toString());
                    txtUserName.setText(table.getValueAt(selectedRow, 1).toString());
                    txtFirstName.setText(table.getValueAt(selectedRow, 2).toString());
                    txtLastName.setText(table.getValueAt(selectedRow, 3).toString());
                    txtEmail.setText(table.getValueAt(selectedRow, 4).toString());
                    txtPhone.setText(table.getValueAt(selectedRow, 5).toString());
                    txtIsDriver.setText(table.getValueAt(selectedRow, 6).toString());
                    if (table.getValueAt(selectedRow, 7).toString().equals("true")) {isAdmin.setSelected(true);}
                    else { isUser.setSelected(true);  }
                    txtEmpImage.setText(table.getValueAt(selectedRow, 8).toString());
                    ImageIcon imageIcon = new ImageIcon(txtEmpImage.getText());
                    imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 250, Image.SCALE_SMOOTH));
                    lblImagePreview.setIcon(imageIcon);

                    int userId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                    showReservationCount(userId);
                    showObservationCount(userId);

                    deleteButton.setEnabled(true);
                    updateButton.setEnabled(true);
                    printButton.setEnabled(true);
                    clearButton.setEnabled(true);
                    saveButton.setEnabled(false);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane(table);
        footerPanel.add(jScrollPane, BorderLayout.CENTER);
        showUser(table);

        setVisible(true);
    }

    private void showObservationCount(int userId) {
        ObservationService observationService = new ObservationService();
        int observationCount = observationService.getObservationCount(userId);
        txtEstimations.setText(String.valueOf(observationCount));
    }


    private void showReservationCount(int userId) {
        ReservationService reservationService = new ReservationService();
        int reservationCount = reservationService.getReservationCount(userId);
        txtReservations.setText(String.valueOf(reservationCount));
    }

    public void showUser(JTable table)  {
        userService = new UserService();
        List<ResponseUtilisateurDTO> responseUtilisateurDTO = userService.getAll();
        BottomUserTableModel model = new BottomUserTableModel(responseUtilisateurDTO);
        table.setModel(model);
        table.repaint();

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new UserUI();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

    }
}
