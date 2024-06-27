package com.example.CrudProducts.config;

import com.example.CrudProducts.security.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /********** METODO DE SEGURIDAD WEB **********/
    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // (2)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger.yaml").permitAll()
                        .requestMatchers("/authenticate").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/**").authenticated()
                        .anyRequest().authenticated()
                )
                .cors(withDefaults())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        return http.build();
    }

    /********** METODO DE CIFRARDO MEDIANTE BCRYPT **********/
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /********** METODO PARA GESTIONAR AUTENTICACIÓN **********/
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /********** METODO CIFRAR UNA CONTRASEÑA ESPECÍFICA **********/
//    public static void main (String[] args) {
//        System.out.println("pass: " + new BCryptPasswordEncoder().encode("ezete"));
//    }

}

