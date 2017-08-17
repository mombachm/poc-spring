package com.sap.training.services.impls;

import com.sap.training.daos.UserDao;
import com.sap.training.models.User;
import com.sap.training.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

public class DefaultUserService implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user){
        encodeUserPasswords(user);
        userDao.save(user);
    }

    @Override
    public boolean userEmailExists(String userEmail){
        if(userDao.getUserByEmail(userEmail) != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void encodeUserPasswords(User user){
        user.setPassword(encodePassword(user.getPassword()));
        user.setPasswordConfirm(encodePassword(user.getPasswordConfirm()));
    }

    @Override
    public boolean confirmPassword(User user){
        User dbUser = userDao.getUserByEmail(user.getEmail());
        return user.getPassword().equals(dbUser.getPassword());
    }

    @Override
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
