package com.example.dto.reservation;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestReservationDTO {
    private Long id;
    private String departure;
    private String arrival;
    private String date;
    private Double price;
    private Long driverId;
    private Long clientId;
    private Long estimationId;
}