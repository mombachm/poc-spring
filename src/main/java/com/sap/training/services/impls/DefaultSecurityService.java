package com.sap.training.services.impls;

import com.sap.training.services.SecurityService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class DefaultSecurityService implements SecurityService{

    @Override
    public boolean isLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return true;
        }
        return false;
    }
}
