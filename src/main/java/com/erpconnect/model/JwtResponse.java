package com.erpconnect.model;

import java.io.Serializable;

public class JwtResponse {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String access_token;


    public JwtResponse(String token) {
        this.access_token = token;
    }

    public String getAccess_token() {
        return access_token;
    }
}
