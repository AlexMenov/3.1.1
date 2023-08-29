package com.userscrud.userscrud.services;

import com.userscrud.userscrud.dao.UserRepository;
import com.userscrud.userscrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIml implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceIml (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Iterable<User> getUsers () {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userRepository.findById(Long.valueOf(id));
    }

    @Override
    public String deleteUserById(String id) {
        userRepository.deleteById(Long.valueOf(id));
        return id;
    }
}
