package com.sourav.calculator.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class BasicAuthWebSecurityConfiguration
{
    //@Autowired
    //private AppBasicAuthenticationEntryPoint authenticationEntryPoint;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                . authorizeRequests()
                //.antMatchers("/grades").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/grades/**").hasRole("USER")
                //.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                //.authenticationEntryPoint(authenticationEntryPoint);
        return http.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User
//                .withUsername("user")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER_ROLE")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Bean
    public UserDetailsService userDetailsService1() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin-pass"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user-pass"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}