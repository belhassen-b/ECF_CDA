package com.example.celestobservation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CelestObjectDTO {

    private Long id;
    private String name;
    private String type;
    private String description;
    private String image;
}

