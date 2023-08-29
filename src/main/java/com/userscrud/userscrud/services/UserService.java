package com.userscrud.userscrud.services;

import com.userscrud.userscrud.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> getUsers ();
    void createUser (User user);
    Optional<User> findUserById (String id);
    String deleteUserById (String id);
}
