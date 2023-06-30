package com.example.ecf3.controller;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.Tournament;
import com.example.ecf3.entity.User;
import com.example.ecf3.service.ITournamentService;
import com.example.ecf3.util.Utils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tournaments")
public class TournamentController {

    private final ITournamentService tournamentService;
    private final HttpSession httpSession;

    @GetMapping("/addTournament")
    public String addTournament(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/error";
        }
        if (!((User) httpSession.getAttribute("user")).isAdmin()) {
            return "redirect:/error";
        }
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
                                  @RequestParam String dateTime) {
          Tournament tournament = Tournament.builder()
                .name(name)
                .dateTime(String.valueOf(Utils.parseDateString(dateTime)))
                .build();
        tournamentService.save(tournament);
        return "redirect:/tournaments/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable("id") Long id) {
        Tournament t = tournamentService.findById(id);
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/error";
        }
        if (!((User) httpSession.getAttribute("user")).isAdmin()) {
            return "redirect:/error";
        }
        if (t != null && tournamentService.deleteById(id)) {
            log.info("Tournament deleted: " + t.getName());
            return "redirect:/tournaments/admin";
        }
        return "error";
    }

    @GetMapping("/edit/{id}")
    public String editTournament(@PathVariable("id") Long id, Model model) {
        Tournament t = tournamentService.findById(id);
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/error";
        }
        if (!((User) httpSession.getAttribute("user")).isAdmin()) {
            return "redirect:/error";
        }
        if (t != null) {
            model.addAttribute("tournament", t);
            return "updateTournament";
        }
        return "error";
    }

    @PostMapping("/update/{id}")
    public String updateTournament(@PathVariable("id") Long id,
                                       @ModelAttribute Tournament tournament) {
        Tournament t = tournamentService.findById(id);
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/error";
        }
        if (!((User) httpSession.getAttribute("user")).isAdmin()) {
            return "redirect:/error";
        }
        if (t != null) {
            t.setName(tournament.getName());
            t.setDateTime(tournament.getDateTime());
            if (tournamentService.save(t) ) {
        return "redirect:/tournaments/admin";
            }
        }
        return "error";
    }
}

