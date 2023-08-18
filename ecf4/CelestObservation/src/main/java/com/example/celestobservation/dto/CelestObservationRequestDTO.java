package com.example.celestobservation.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CelestObservationRequestDTO {

    private String name;
    private String date;
    private String description;
    private String image;
    private Long celestObjectId;
    private Long userId;
}
