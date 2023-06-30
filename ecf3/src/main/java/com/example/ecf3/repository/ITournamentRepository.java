package com.example.ecf3.repository;

import com.example.ecf3.entity.Tournament;
import com.example.ecf3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ITournamentRepository extends JpaRepository<Tournament, Long> {
    Tournament findByName(String tournament);


}
