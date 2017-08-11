package com.sap.training.daos;

import com.sap.training.models.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void deleteUser(String email);

    User getUserByEmail(String email);
}
