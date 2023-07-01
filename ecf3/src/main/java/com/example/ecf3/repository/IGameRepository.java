package com.example.ecf3.repository;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByWhitePlayerOrBlackPlayer(User user, User user1);
}
