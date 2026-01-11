package com.loginapp.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.loginapp.login.services.UserService;


@Configuration
public class SecurityConfig {
    private final UserService userService;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public SecurityConfig(UserService userService, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.userService = userService;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/DetailPage/**", "/users/register", "/images/**" , "/style/**","/css/**" , "/script/**").permitAll()
                .requestMatchers("/webShop/adminPanel").hasRole("ADMIN")
                .anyRequest().authenticated()
        )

        .userDetailsService(userService)
        .formLogin(form -> form
            .successHandler(customAuthenticationSuccessHandler)
            .permitAll()
        )
        .logout(form -> form
            .logoutSuccessUrl("/")
            .permitAll()
        )
        .httpBasic(Customizer.withDefaults());
        return http.build();    
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
