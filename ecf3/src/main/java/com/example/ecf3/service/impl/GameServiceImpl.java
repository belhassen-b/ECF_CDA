package com.example.ecf3.service.impl;


import com.example.ecf3.entity.Game;
import com.example.ecf3.repository.IGameRepository;
import com.example.ecf3.service.IGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class GameServiceImpl  implements IGameService {

    private final IGameRepository gameRepository;


    @Override
    public boolean save(Game game) {
        return false;
    }
}
