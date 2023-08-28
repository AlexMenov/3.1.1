package com.userscrud.userscrud.controller;

import com.userscrud.userscrud.dao.UserRepository;
import com.userscrud.userscrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(user);
        userRepo.save(user);
        return "redirect:/users";
    }
}
