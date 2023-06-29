package com.example.ecf3.controller;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.Tournament;
import com.example.ecf3.service.ITournamentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tournaments")
public class TournamentController {

    private final ITournamentService tournamentService;

    @GetMapping("/addTournament")
    public String addTournament(Model model) {
        model.addAttribute("tournament", new Game());
        return "addTournament";
    }


    @GetMapping("/admin")
    public String showTournaments(Model model) {
        model.addAttribute("tournaments", tournamentService.findAll());
        return "adminTournament";
    }

    @PostMapping("/create")
    public String creatTournament(@RequestParam("name") String name,
                                  @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Tournament tournament = Tournament.builder()
                .name(name)
                .date(date)
                .build();
        tournamentService.save(tournament);
        return "redirect:/tournaments/admin";
    }


}

