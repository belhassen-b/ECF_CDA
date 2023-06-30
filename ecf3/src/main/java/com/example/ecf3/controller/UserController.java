package com.example.ecf3.controller;

import com.example.ecf3.entity.User;
import com.example.ecf3.service.IGameService;
import com.example.ecf3.service.ITournamentService;
import com.example.ecf3.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;
    private final IGameService gameService;
    private final ITournamentService tournamentService;

//    @GetMapping("/profil/{id}")
//    public String showUser(@PathVariable("id") Long id, Model model) {
//        User user = userService.findById(id);
//        if(user.isAdmin()){
//            return "redirect:/tournaments/admin";
//        }
//        model.addAttribute("user", user);
//        return "profil";
//    }

    //show user profil with his games
    @GetMapping("/profil/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        if(user.isAdmin()){
            return "redirect:/tournaments/admin";
        }
        model.addAttribute("user", user);
        model.addAttribute("games", gameService.findAllByWhitePlayerOrBlackPlayer(user, user));
        return "profil";
    }


}