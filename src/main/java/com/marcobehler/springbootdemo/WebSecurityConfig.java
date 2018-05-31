package com.marcobehler.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    //.antMatchers("/", "/login").permitAll()
                    .anyRequest().authenticated()
            .and()
                .httpBasic()
            .and()
                .csrf().disable();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails userDetail = User.withUsername("hans").password("dampf")
                .roles("USER").build();
        return new InMemoryUserDetailsManager(Arrays.asList(userDetail));
    }
}
