package com.example.dto.reservation;

import lombok.Data;

@Data

public class ResponseTakeReservationDTO {
    private Long id;
    private String departure;
    private String arrival;
    private String date;
    private Double price;
    private Long driverId;
    private Long clientId;
    private Long estimationId;
}
