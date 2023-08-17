package com.example.celestobject.controller;


import com.example.celestobject.entity.CelestObject;
import com.example.celestobject.service.CelestObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/celestobject")
public class CelestObjectController {

    private final CelestObjectService celestObjectService;

    public CelestObjectController(CelestObjectService celestObjectService) {
        this.celestObjectService = celestObjectService;
    }

    @PostMapping("")
    public ResponseEntity<CelestObject> post(@RequestParam String name, @RequestParam String type, @RequestParam String description, @RequestParam String image) {
        CelestObject celestObject = celestObjectService.createCelestObject(name, type, description, image);
        return ResponseEntity.ok(celestObject);
    }

    @GetMapping("{id}")
    public ResponseEntity<CelestObject> get(@PathVariable Long id) {
        CelestObject celestObject = celestObjectService.getCelestObjectById(id);
        return ResponseEntity.ok(celestObject);
    }

// getMapping userID

}
