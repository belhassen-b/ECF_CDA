package com.example.ecf3.service;

import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.User;

import java.util.List;


public interface IGameService {

    boolean save(Game game);

    Game findById(Long id);

    List<Game> findAllByWhitePlayerOrBlackPlayer(User user, User user1);
}
