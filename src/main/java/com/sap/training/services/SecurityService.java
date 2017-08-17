package com.sap.training.services;

import com.sap.training.models.User;

public interface SecurityService {

    boolean isLogged();

    User getLoggedUser();
}
