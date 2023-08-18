package com.example.celestobservation.controller;

import com.example.celestobservation.dto.CelestObservationRequestDTO;
import com.example.celestobservation.service.CelestObservationService;
import com.example.celestobservation.entity.CelestObservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/celestobservation")
public class CelestObservationController {

    private final CelestObservationService celestObservationService;

    public CelestObservationController(CelestObservationService celestObservationService) {
        this.celestObservationService = celestObservationService;
    }

    @PostMapping("")
    public ResponseEntity<CelestObservation> post(@RequestBody CelestObservationRequestDTO celestObservationRequestDTO) {
        CelestObservation celestObservation = celestObservationService.createCelestObservation(
                celestObservationRequestDTO.getName(),
                celestObservationRequestDTO.getDate(),
                celestObservationRequestDTO.getDescription(),
                celestObservationRequestDTO.getImage(),
                celestObservationRequestDTO.getCelestObjectId(),
                celestObservationRequestDTO.getUserId()
        );
        return ResponseEntity.ok(celestObservation);
    }



    @GetMapping("{id}")

    public ResponseEntity<CelestObservation> get(@PathVariable Long id) {
        CelestObservation celestObservation = celestObservationService.getCelestObservationById(id);
        return ResponseEntity.ok(celestObservation);
    }

    @GetMapping("user/{userId}")

    public ResponseEntity<CelestObservation> getByUserId(@PathVariable Long userId) {
        try {
            CelestObservation celestObservation = celestObservationService.getCelestObservationByUserId(userId);
            return ResponseEntity.ok(celestObservation);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("date/{date}")
    public ResponseEntity<CelestObservation> getByDate(@PathVariable String date) {
        try {
            CelestObservation celestObservation = celestObservationService.getCelestObservationByDate(date);
            return ResponseEntity.ok(celestObservation);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
