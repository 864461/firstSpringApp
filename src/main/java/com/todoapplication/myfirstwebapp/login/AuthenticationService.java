package com.todoapplication.myfirstwebapp.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authentication(String username, String password) {
        boolean isValidName = username.equalsIgnoreCase("alvin");
        boolean isValidPassword = password.equalsIgnoreCase("test");

        return isValidName && isValidPassword;
    }
}
