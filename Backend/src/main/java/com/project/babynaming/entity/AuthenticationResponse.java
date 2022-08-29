package com.project.babynaming.entity;

public class AuthenticationResponse {
    private final String jwt;
    private LoginRegisterModel user;

    public AuthenticationResponse(String jwt, LoginRegisterModel user) {
        this.jwt = jwt;
        this.user = user;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;

    }

    public LoginRegisterModel getUser() {
        return user;
    }

    public void setUser(LoginRegisterModel user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }
}
