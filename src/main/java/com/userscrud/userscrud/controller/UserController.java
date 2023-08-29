package com.userscrud.userscrud.controller;

import com.userscrud.userscrud.model.User;
import com.userscrud.userscrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("users")
    public Iterable<User> users() {
        return userService.getUsers();
    }

    @GetMapping
    public String getUsers() {
        return "users";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable(name = "userId") String id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user";
    }
}
