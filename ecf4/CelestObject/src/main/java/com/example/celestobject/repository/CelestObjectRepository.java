package com.example.celestobject.repository;

import com.example.celestobject.entity.CelestObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CelestObjectRepository extends JpaRepository<CelestObject, Long> {

    CelestObject findCelestObjectById(Long id);

}
