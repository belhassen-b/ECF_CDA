package com.example.ecf3.controller;


import com.example.ecf3.entity.User;
import com.example.ecf3.service.IUserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private IUserService userService;

    private HttpSession httpSession;

    @Autowired
    public AuthController(IUserService userService, HttpSession httpSession) {
        this.userService = userService;
        this.httpSession = httpSession;
    }


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        User user = userService.findByUsernameAndPassword(username, password);
        log.info("user: {}", user);
        if (user != null) {
            httpSession.setAttribute("user", user);
            if (user.isAdmin())
                return "redirect:/tournaments/admin";
            else return "redirect:/user/profil/" + user.getId();
        }
        return "loginError";
    }

    @RequestMapping("/logout")
    public String logout() {
        httpSession.invalidate();
        httpSession = null;
        return "/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        if(userService.findIfUserExists(username, email)){
            return "registerError";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userService.save(user);
        return "redirect:/login";
    }
}
