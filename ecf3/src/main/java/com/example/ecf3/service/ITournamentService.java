package com.example.ecf3.service;

import com.example.ecf3.entity.Tournament;
import com.example.ecf3.entity.User;
import java.util.List;

public interface ITournamentService {

    List<Tournament> findAll();

    boolean save(Tournament tournament);

    Tournament findById(Long id);

    Tournament findByName(String tournament);

    boolean deleteById(Long id);

    boolean update(Tournament t);

    Tournament findAllByUser(User user);
}

