package com.example.model;


import com.example.dto.reservation.ResponseReservationDTO;
import com.example.observation.entity.Reservation;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class RightReservationTableModel extends AbstractTableModel implements TableModel {
private final List<Reservation> data;

private final String[] columnNames = {"Id", "Departure", "Arrival", "Date", "Price", "ClientId","DriverId",  "EstimationId"};


public RightReservationTableModel(List<Reservation> reservationsList) {
        this.data = reservationsList;
        }

@Override
public int getRowCount() {
        return data.size();
        }

@Override
public int getColumnCount() {
        return columnNames.length;
        }

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
        Reservation reservation = data.get(rowIndex);
        return switch (columnIndex) {
        case 0 -> reservation.getId();
        case 1 -> reservation.getDeparture();
        case 2 -> reservation.getArrival();
        case 3 -> reservation.getDate();
        case 4 -> reservation.getPrice();
        case 5 -> reservation.getClientId();
        case 6 -> reservation.getDriverId();
        case 7 -> reservation.getEstimationId();

        default -> null;
        };
        }

@Override
public String getColumnName(int column) {
        return columnNames[column];
        }



}
