package com.eni.encheres.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    private final String SELECT_USER = "select pseudo, mot_de_passe, 1 from utilisateurs where pseudo=?";
    private final String SELECT_ROLES = "select u.pseudo, r.role from utilisateurs u inner join ROLES r on r.IS_ADMIN = u.administrateur where u.pseudo = ?";

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(SELECT_USER);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(SELECT_ROLES);
        return jdbcUserDetailsManager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth
                    .requestMatchers(HttpMethod.GET, "/test").permitAll()
                    .requestMatchers("/css/**", "/images/**").permitAll()
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/articles/list").permitAll()
                    .anyRequest().authenticated();
        });

        http.formLogin(form -> {
            form.loginPage("/login").permitAll();
            form.defaultSuccessUrl("/session").permitAll();
        });
        return http.getOrBuild();
    }
}
