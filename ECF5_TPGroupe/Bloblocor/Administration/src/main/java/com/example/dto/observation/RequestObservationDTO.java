package com.example.dto.observation;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestObservationDTO {
    private String id;

    private Integer notation;
    private String comment;
    private Long idClient;
    private Long idReservation;
}
