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

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable("id") Long id){
       Tournament t =  tournamentService.findById(id);
        if( t != null && tournamentService.deleteById(id)){
            log.info("Tournament deleted: " + t.getName());
            return "redirect:/tournaments/admin";
        }
        return "Aucun tournoi avec cet id";
    }

    @GetMapping("/edit/{id}")
    public String editTournament(@PathVariable("id") Long id, Model model){
        Tournament t = tournamentService.findById(id);
        if(t != null){
            model.addAttribute("tournament", t);
            return "addTournament";
        }
        return "Aucun tournoi avec cet id";
    }

    @PostMapping("/update/{id}")
    public Tournament updateTournament(@PathVariable("id") Long id,
                                      @ModelAttribute Tournament tournament){
        Tournament t = tournamentService.findById(id);
        if(t != null){
            t.setName(tournament.getName());
            t.setDate(tournament.getDate());
            tournamentService.update(t);
            return t;
        }
        return t;
    }



}

