package com.ltp.gradesubmission.security.manager;

import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    UserService userService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userService.getUser(authentication.getName());
        if(!user.getPassword().equals(authentication.getCredentials().toString())) {
            System.out.println(user.getPassword());
            System.out.println(authentication.getCredentials());
            throw new BadCredentialsException("Wrong Pasword");
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    }
}
