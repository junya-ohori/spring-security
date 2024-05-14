package com.example.its.config;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.startup.WebappServiceLoader;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // for hs-console
        http
            .authorizeRequests().antMatchers("/h2-console/**").permitAll()
            .and()
            .csrf().ignoringAntMatchers("/h2-console/**")
            .and()
            .headers().frameOptions().disable();

        http
            .authorizeRequests()
            .mvcMatchers("/login/**").permitAll()
            .mvcMatchers("/users/**").hasAnyAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
//                .usernameParameter("") htmlのname属性をデフォルトから変えたい場合
//                .passwordParameter("") htmlのname属性をデフォルトから変えたい場合
            .loginPage("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }
}
