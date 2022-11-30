package com.example.sprin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration

public class SecurityConfig  {

@Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

    return http.csrf().disable()
            .oauth2Login()
            .and()
            .authorizeRequests()
            .antMatchers("/user")
            .authenticated()
             .antMatchers("/**").permitAll()
            .and()
            .build();



}



}

/*

    return  http.oauth2Login()
             .and()
            .authorizeRequests()
            .antMatchers("/user","/**")
            .permitAll()
            .anyRequest().
            authenticated()
            .and()
            .build();

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception
    {
        return http
                .oauth2Login()
                .and()
                .authorizeRequests()
                .antMatchers("/user")
                .authenticated()
                .antMatchers("/**")
                .permitAll()
                .and()
                .build();
    }
}



    }*/













/*

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.authorizeRequests()
            .anyRequest().authenticated()
            .and().oauth2Login();
           return http.build();
}
}



*/
/*
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception
    {

      return http
                .oauth2Login()
                .successHandler(new AuthenticationHandler())
                .and()
                .authorizeRequests()
                .antMatchers("/user")
                .authenticated()
                .antMatchers("/**")
                .permitAll()
                .and()
                .build();
    }

}


        http
                .authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/webjars/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login();
*/
