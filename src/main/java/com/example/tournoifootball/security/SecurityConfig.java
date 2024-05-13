package com.example.tournoifootball.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authoCustomizer -> authoCustomizer
                                .requestMatchers("/editTournoi","/updateTournoi", "deleteTournoi").hasRole("ADMIN")
                                .requestMatchers("/createTournoi","/saveTournoi").hasAnyRole("ADMIN","OUSSAMA")
                                .requestMatchers("/tournoiList").hasAnyRole("ADMIN","OUSSAMA","USER")
                                .anyRequest().authenticated()

                )
        .exceptionHandling(e->e.accessDeniedPage("/accessdenied"));

        return httpSecurity.build();

    }
    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(bCryptPasswordEncoder().encode("123")).roles("ADMIN","USER").build(),
                User.withUsername("oussama").password(bCryptPasswordEncoder().encode("123")).roles("OUSSAMA").build(),
                User.withUsername("accountant").password(bCryptPasswordEncoder().encode("123")).roles("USER").build()
        );
    }
}
