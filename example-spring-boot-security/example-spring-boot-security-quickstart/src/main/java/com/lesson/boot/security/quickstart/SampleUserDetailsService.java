package com.lesson.boot.security.quickstart;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import static java.util.Arrays.*;

/**
 * @author zhengshijun
 * @version created on 2018/12/19.
 */
@Service
public class SampleUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = new User(username,"",true,true,true,true, new ArrayList<SimpleGrantedAuthority>());

        return user;
    }
}
