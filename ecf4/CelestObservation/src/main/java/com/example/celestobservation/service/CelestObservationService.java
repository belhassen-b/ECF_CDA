package com.example.celestobservation.service;


import com.example.celestobservation.entity.CelestObservation;
import com.example.celestobservation.repository.CelestObservationRepository;
import org.springframework.stereotype.Service;

@Service
public class CelestObservationService {

    private final CelestObservationRepository celestObservationRepository;

    public CelestObservationService(CelestObservationRepository celestObservationRepository) {
        this.celestObservationRepository = celestObservationRepository;
    }


    public CelestObservation createCelestObservation(String name, String date, String description, String image, Long celestObjectId, Long userId) {
        CelestObservation celestObservation = CelestObservation.builder().name(name).date(date).description(description).image(image).celestObjectId(celestObjectId).userId(userId).build();
        celestObservationRepository.save(celestObservation);
        return celestObservation;
    }


    public CelestObservation getCelestObservationById(Long id) {
        return celestObservationRepository.findById(id).get();
    }
}



