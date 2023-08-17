package com.example.celestobject.service;


import com.example.celestobject.entity.CelestObject;
import com.example.celestobject.repository.CelestObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class CelestObjectService {

    private final CelestObjectRepository celestObjectRepository;

    public CelestObjectService(CelestObjectRepository celestObjectRepository) {
        this.celestObjectRepository = celestObjectRepository;
    }

    public CelestObject createCelestObject(String name, String type, String description, String image) {
        CelestObject celestObject = CelestObject.builder().name(name).type(type).description(description).image(image).build();
        celestObjectRepository.save(celestObject);
        return celestObject;
    }


    public CelestObject getCelestObjectById(Long id) {
        return celestObjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }


}
