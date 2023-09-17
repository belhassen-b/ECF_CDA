package com.example.model;


import com.example.dto.utilisateur.ResponseUtilisateurDTO;
import lombok.Data;

import javax.swing.table.AbstractTableModel;
import java.util.List;


@Data
public class BottomUserTableModel extends AbstractTableModel {

    private final List<ResponseUtilisateurDTO> data;
    private final String[] columnNames = {"Id", "Username", "FirstName", "LastName", "Email", "Phone", "isDriver", "isAdmin", "Avatar"};

    public BottomUserTableModel(List<ResponseUtilisateurDTO> usersList) {
        this.data = usersList;
    }

    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ResponseUtilisateurDTO user = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> user.getId();
            case 1 -> user.getUsername();
            case 2 -> user.getFirstname();
            case 3 -> user.getLastname();
            case 4 -> user.getEmail();
            case 5 -> user.getPhone();
            case 6 -> user.isDriver();
            case 7 -> user.isAdmin();
            case 8 -> user.getAvatar();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}