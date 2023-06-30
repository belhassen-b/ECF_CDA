package com.example.ecf3.repository;


import com.example.ecf3.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long> {

    boolean existsByWhitePlayerIdAndBlackPlayerId(Long whitePlayerId, Long blackPlayerId);


}
