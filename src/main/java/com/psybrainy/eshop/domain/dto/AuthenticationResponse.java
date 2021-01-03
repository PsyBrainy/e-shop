package com.psybrainy.eshop.domain.dto;

public class AuthenticationResponse {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
