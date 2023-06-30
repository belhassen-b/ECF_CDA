package com.example.ecf3.service;

import com.example.ecf3.entity.Tournament;
import java.util.Date;
import java.util.List;

public interface ITournamentService {
    boolean save(String name, Date date);

    List<Tournament> findAll();

    boolean save(Tournament tournament);

    Tournament findById(Long id);

    Tournament findByName(String tournament);

    boolean deleteById(Long id);

    boolean update(Tournament t);
}

