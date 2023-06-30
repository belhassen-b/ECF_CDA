package com.example.ecf3.service.impl;

import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.Tournament;
import com.example.ecf3.entity.User;
import com.example.ecf3.repository.ITournamentRepository;
import com.example.ecf3.service.ITournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements ITournamentService {

    private final ITournamentRepository tournamentRepository;


    @Override
    public boolean save(String name, Date date) {
        return false;
    }

    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    @Override
    public boolean save(Tournament tournament) {
        tournamentRepository.save(tournament);
        return true;
    }

    @Override
    public Tournament findById(Long id) {
        return tournamentRepository.findById(id).get();
    }

    @Override
    public Tournament findByName(String tournament) {
        return tournamentRepository.findByName(tournament);
    }

    @Override
    public boolean deleteById(Long id) {
        tournamentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean update(Tournament t) {
        tournamentRepository.save(t);
        return true;
    }

    @Override
    public Tournament findAllByUser(User user) {
        return null;
    }


}
