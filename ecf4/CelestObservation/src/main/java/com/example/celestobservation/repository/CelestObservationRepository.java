package com.example.celestobservation.repository;


import com.example.authentication.entity.Utilisateur;
import com.example.celestobservation.entity.CelestObservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CelestObservationRepository extends JpaRepository<CelestObservation, Long> {


    CelestObservation findByUserId(Long userId);

    CelestObservation findByDate(String date);
}
