package com.example.ecf3.controller;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.Tournament;
import com.example.ecf3.entity.User;
import com.example.ecf3.repository.IGameRepository;
import com.example.ecf3.service.IGameService;
import com.example.ecf3.service.ITournamentService;
import com.example.ecf3.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameController {

    private final IGameService gameService;

    private final IGameRepository gameRepository;

    private final IUserService userService;

    private final ITournamentService tournamentService;


    @GetMapping("/gameList")
    public String showGames(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        model.addAttribute("players", userService.findAll());
        model.addAttribute("tournaments", tournamentService.findAll());
        return "addGame";
    }


    @PostMapping("/create")
    public String createGame(@RequestParam Long player1, @RequestParam Long player2, @RequestParam String dateTime, @RequestParam Long tournament) {
        User player1User = userService.findById(player1);
        User player2User = userService.findById(player2);
        Tournament tournament1 = tournamentService.findById(tournament);
        Game game = Game.builder()
                .player1(player1User)
                .player2(player2User)
                .dateTime(dateTime)
                .tournament(tournament1)
                .build();
        gameService.save(game);
        return "redirect:/games/gameList";
    }
}