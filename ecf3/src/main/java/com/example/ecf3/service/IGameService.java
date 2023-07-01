package com.example.ecf3.service;

import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.User;

import java.util.List;
import java.util.Set;


public interface IGameService {

    void save(Game game);

    Game findById(Long id);

    List<Game> findAllByWhitePlayerOrBlackPlayer(User user, User user1);

    Set<Game> AllGame(User user);

    boolean deleteById(Long id);
}
