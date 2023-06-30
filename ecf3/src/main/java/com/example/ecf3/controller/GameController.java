package com.example.ecf3.controller;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.Result;
import com.example.ecf3.entity.Tournament;
import com.example.ecf3.entity.User;
import com.example.ecf3.repository.IGameRepository;
import com.example.ecf3.repository.IResultRepository;
import com.example.ecf3.service.IGameService;
import com.example.ecf3.service.ITournamentService;
import com.example.ecf3.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameController {

    private final IGameService gameService;

    private final IGameRepository gameRepository;

    private final IUserService userService;

    private final ITournamentService tournamentService;


    private final IResultRepository resultRepository;


    @GetMapping("/gameAdd")
    public String showGames(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("tournaments", tournamentService.findAll());
        return "addGame";
    }

    @GetMapping("/gameList")
    public String showGamesList(Model model) {
        List<Game> games = gameRepository.findAll();
games.stream().map(Game::getResult).forEach(System.out::println);

        model.addAttribute("games", gameRepository.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("tournaments", tournamentService.findAll());
        return "adminGame";
    }

    @PostMapping("/create")
    public String add(@RequestParam Long whitePlayer, @RequestParam Long blackPlayer, @RequestParam String dateTime, @RequestParam Long tournament) {
        User whitePlayer1 = userService.findById(whitePlayer);
        User blackPlayer1 = userService.findById(blackPlayer);
        Result result = new Result();
        result.setWinner(whitePlayer1);
        resultRepository.save(result);
        Tournament tournament1 = tournamentService.findById(tournament);
        Game game = Game.builder()
                .whitePlayer(whitePlayer1)
                .blackPlayer(blackPlayer1)
                .dateTime(dateTime)
                .result(result)
                .tournament(tournament1)
                .build();

        gameService.save(game);
        return "redirect:/games/gameAdd";
    }

    @GetMapping("/edit/{id}")
    public String editGame(@PathVariable("id") Long id, Model model) {
        Game g = gameService.findById(id);
        model.addAttribute("game", g);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("tournaments", tournamentService.findAll());
        return "updateGame";
    }

    @PostMapping("/update/{id}")
    public String updateGame(@RequestParam Long id, @RequestParam Long whitePlayer, @RequestParam Long blackPlayer, @RequestParam String dateTime, @RequestParam Long tournament, @RequestParam Result result) {
        User whitePlayer1 = userService.findById(whitePlayer);
        User blackPlayer1 = userService.findById(blackPlayer);
        Tournament tournament1 = tournamentService.findById(tournament);
        Game game = Game.builder()
                .id(id)
                .whitePlayer(whitePlayer1)
                .blackPlayer(blackPlayer1)
                .dateTime(dateTime)
                .tournament(tournament1)
                .result(result)
                .build();
        gameService.save(game);
        return "redirect:/games/gameList";
    }

    @GetMapping("/setWinner/{gameId}/{playerId}")
    public String setWinner(@PathVariable("gameId") Long id, @PathVariable("playerId") Long playerId) {
        System.out.println("gameId: " + id + " playerId: " + playerId);
        Game game = gameService.findById(id);
        User player = userService.findById(playerId);
    game.getResult().setWinner(player);
        gameService.save(game);
        return "redirect:/games/gameList";
    }

}

