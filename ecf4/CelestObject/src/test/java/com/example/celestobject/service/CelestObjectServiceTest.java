package com.example.celestobject.service;

import com.example.celestobject.entity.CelestObject;
import com.example.celestobject.repository.CelestObjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CelestObjectServiceTest {

 @Mock
    private CelestObjectRepository celestObjectRepository;

 @InjectMocks
    private CelestObjectService celestObjectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldCreateCelestObject() {
        //Arrange
        when(celestObjectRepository.save(any(CelestObject.class))).thenReturn(new CelestObject());

        //Act
        CelestObject result = celestObjectService.createCelestObject("name", "type", "desc", "image");

        //Assert
        verify(celestObjectRepository).save(any(CelestObject.class));
    }

    @Test
    void shouldGetCelestObjectByIdIfExist() {
        //Arrange
        when(celestObjectRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(new CelestObject()));

        //Act
        CelestObject result = celestObjectService.getCelestObjectById(1L);

        //Assert
        verify(celestObjectRepository).findById(any(Long.class));
    }
}