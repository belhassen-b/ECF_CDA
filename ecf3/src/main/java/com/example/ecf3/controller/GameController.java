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
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private final HttpSession httpSession;


    @GetMapping("/gameAdd")
    public String showGames(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/user/login";
        } else if (!((User) httpSession.getAttribute("user")).isAdmin()) {
            return "redirect:/error";
        }
        model.addAttribute("game", new Game());
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
    public String add(@RequestParam Long whitePlayer, @RequestParam Long blackPlayer, @RequestParam String dateTime, @RequestParam Long tournament, RedirectAttributes redirAttrs) {
        User whitePlayer1 = userService.findById(whitePlayer);
        User blackPlayer1 = userService.findById(blackPlayer);
        if (whitePlayer1 == null || blackPlayer1 == null || dateTime == null || dateTime.isEmpty()
                || whitePlayer1.equals(blackPlayer1)) {
            redirAttrs.addFlashAttribute("error", "Erreur lors de la création ...");
        }
        else {
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
            redirAttrs.addFlashAttribute("success", "Partie créée.");
            return "redirect:/games/gameAdd";
        }
        return "redirect:/games/gameAdd";
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        gameService.deleteById(id);
        return "redirect:/games/gameList";
    }

}

