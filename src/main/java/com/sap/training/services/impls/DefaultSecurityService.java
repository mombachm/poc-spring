package com.sap.training.services.impls;

import com.sap.training.daos.UserDao;
import com.sap.training.models.User;
import com.sap.training.services.SecurityService;
import com.sap.training.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;

public class DefaultSecurityService implements SecurityService{
    @Resource
    private UserService userService;

    @Override
    public boolean isLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return true;
        }
        return false;
    }

    @Override
    public User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return userService.getUserByEmail(userEmail);
    }
}
