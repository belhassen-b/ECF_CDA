package com.example.celestobservation.dto;

import com.example.celestobservation.entity.CelestObservation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CelestObservationResponseDTO {

    private List<CelestObservation> celestObservations;
    private CelestObjectDTO celestObjectDTO;
}
