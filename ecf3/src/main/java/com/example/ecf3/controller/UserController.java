package com.example.ecf3.controller;

import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.User;
import com.example.ecf3.service.IGameService;
import com.example.ecf3.service.IUserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;
    private final IGameService gameService;
    private final HttpSession httpSession;


    @GetMapping("/profil/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        List<Game> allGames = gameService.AllGame(user).stream().toList();
        if (user.isAdmin()) {
            return "redirect:/tournaments/admin";
        }
        model.addAttribute("user", user);
        model.addAttribute("games", allGames);
        return "profil";
    }

    @GetMapping("/addPlayer")
    public String addPlayer(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/error";
        }
        if (!((User) httpSession.getAttribute("user")).isAdmin()) {
            return "redirect:/error";
        }
        model.addAttribute("user", new User());
        return "addPlayer";
    }
}
