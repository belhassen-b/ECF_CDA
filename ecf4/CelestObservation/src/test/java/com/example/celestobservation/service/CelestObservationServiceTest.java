package com.example.celestobservation.service;

import com.example.celestobservation.entity.CelestObservation;
import com.example.celestobservation.repository.CelestObservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CelestObservationServiceTest {



    @Mock
    private CelestObservationRepository celestObservationRepository;

    @InjectMocks
    private CelestObservationService celestObservationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCelestObservation() {
        // Arrange
        when(celestObservationRepository.save(any(CelestObservation.class))).thenReturn(new CelestObservation());

        // Act
        CelestObservation result = celestObservationService.createCelestObservation("name", "date", "desc", "image", 1L, 1L);

        // Assert
        verify(celestObservationRepository).save(any(CelestObservation.class));
    }

    @Test

    public void testGetCelestObservationById() {
        // Arrange
        when(celestObservationRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(new CelestObservation()));

        // Act
        CelestObservation result = celestObservationService.getCelestObservationById(1L);

        // Assert
        verify(celestObservationRepository).findById(any(Long.class));
    }

    @Test

    public void testGetCelestObservationByUserId() {
        // Arrange
        when(celestObservationRepository.findByUserId(any(Long.class))).thenReturn(new CelestObservation());

        // Act
        CelestObservation result = celestObservationService.getCelestObservationByUserId(1L);

        // Assert
        verify(celestObservationRepository).findByUserId(any(Long.class));
    }

    @Test

    public void testGetCelestObservationByDate() {
        // Arrange
        when(celestObservationRepository.findByDate(any(String.class))).thenReturn(new CelestObservation());

        // Act
        CelestObservation result = celestObservationService.getCelestObservationByDate("date");

        // Assert
        verify(celestObservationRepository).findByDate(any(String.class));
    }

}

