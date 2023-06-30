package com.example.ecf3.service.impl;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.User;
import com.example.ecf3.repository.IGameRepository;
import com.example.ecf3.repository.IResultRepository;
import com.example.ecf3.service.IGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor

public class GameServiceImpl  implements IGameService {

    private final IGameRepository gameRepository;
    private final IResultRepository resultRepository;


    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public List<Game> findAllByWhitePlayerOrBlackPlayer(User user, User user1) {
        return gameRepository.findAllByWhitePlayerOrBlackPlayer(user, user1);
    }

    @Override
    public Set<Game> AllGame(User user) {
        Set<Game> allGames = new HashSet<>();
        allGames.addAll(user.getBlackPlayer());
        allGames.addAll(user.getWhitePlayer());
        return allGames;
    }
}
