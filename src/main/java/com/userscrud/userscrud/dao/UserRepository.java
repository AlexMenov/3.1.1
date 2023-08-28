package com.userscrud.userscrud.dao;

import com.userscrud.userscrud.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "userRepo")
public interface UserRepository extends CrudRepository<User, Long> {
}
