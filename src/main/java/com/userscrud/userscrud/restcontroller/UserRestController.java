package com.userscrud.userscrud.restcontroller;

import com.userscrud.userscrud.dao.UserRepository;
import com.userscrud.userscrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class UserRestController {
    private final UserRepository userRepo;

    @Autowired
    public UserRestController(@Qualifier("userRepo") UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") String id) {
        userRepo.deleteById(Long.valueOf(id));
        return id;
    }
}
