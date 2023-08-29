package com.userscrud.userscrud.controller;

import com.userscrud.userscrud.dao.UserRepository;
import com.userscrud.userscrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepo;

    @Autowired
    public UserController(@Qualifier("userRepo") UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @ModelAttribute("users")
    public Iterable<User> users() {
        return userRepo.findAll();
    }

    @GetMapping
    public String getUsers() {
        return "users";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{userId}")
    public String getUserById (@PathVariable(name = "userId") String id, Model model) {
        Optional<User> user = userRepo.findById(Long.valueOf(id));
        model.addAttribute("user", user);
        return "user";
    }
}
