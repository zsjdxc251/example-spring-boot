package com.lesson.boot.security.quickstart;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author zhengshijun
 * @version created on 2018/12/19.
 */
@Component
public class SampleAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {



        return null;
    }
}
