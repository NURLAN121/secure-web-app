package com.example.securewebapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthFailureListener {

    private static final Logger log =
            LoggerFactory.getLogger(AuthFailureListener.class);

    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent event) {

        Object principal = event.getAuthentication().getPrincipal();

        if (principal != null) {
            log.warn("Failed login attempt for user: {}", principal);
        } else {
            log.warn("Failed login attempt (unknown user)");
        }
    }
}
