package com.example.ecf3.service.impl;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.User;
import com.example.ecf3.repository.IGameRepository;
import com.example.ecf3.service.IGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class GameServiceImpl  implements IGameService {

    private final IGameRepository gameRepository;


    @Override
    public boolean save(Game game) {
        gameRepository.save(game);
        return game.getId() > 0;
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public List<Game> findAllByWhitePlayerOrBlackPlayer(User user, User user1) {
        return gameRepository.findAllByWhitePlayerOrBlackPlayer(user, user1);
    }
}
