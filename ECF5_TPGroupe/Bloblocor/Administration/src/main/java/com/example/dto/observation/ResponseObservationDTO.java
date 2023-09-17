package com.example.dto.observation;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseObservationDTO {

    private Integer notation;
    private String comment;
    private Long idClient;
    private Long idDriver;
    private Long idReservation;
    private boolean isEnded;


}
