package com.sap.training.services;

import com.sap.training.models.User;

public interface UserService {
    void saveUser(User user);

    boolean userEmailExists(String userEmail);

    void encodeUserPasswords(User user);

    boolean confirmPassword(User user);

    String encodePassword(String password);

    User getUserByEmail(String email);
}
