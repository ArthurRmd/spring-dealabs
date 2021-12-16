package com.example.dealabs.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class DealabsSpringUser extends User {

    private static final long serialVersionUID = -2836522345185404025L;

    public DealabsSpringUser(final String username, final String password, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
