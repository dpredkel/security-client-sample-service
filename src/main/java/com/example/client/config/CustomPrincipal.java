package com.example.client.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
public class CustomPrincipal extends UsernamePasswordAuthenticationToken {

    @Getter
    private String uuid;

    public CustomPrincipal(String uuid, Object principal, Object credentials) {
        super(principal, credentials);
        this.uuid = uuid;
    }

    public CustomPrincipal(String uuid, Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.uuid = uuid;
    }

}
