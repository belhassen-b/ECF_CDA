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
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("users", userService.findAll());
        model.addAttribute("tournaments", tournamentService.findAll());
        return "addGame";
    }

    @PostMapping("/create")
    public String add( @RequestParam Long whitePlayer, @RequestParam Long blackPlayer,@RequestParam String dateTime, @RequestParam Long tournament) {
        User whitePlayer1 = userService.findById(whitePlayer);
        User blackPlayer1 = userService.findById(blackPlayer);
        Tournament tournament1 = tournamentService.findById(tournament);
        Game game = Game.builder()
                .whitePlayer(whitePlayer1)
                .blackPlayer(blackPlayer1)
                .dateTime(dateTime)
                .tournament(tournament1)
                .build();

        gameService.save(game);
        return "redirect:/games/gameList";
    }


}

