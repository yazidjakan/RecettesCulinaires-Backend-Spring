package com.recettes.miniprojet.recettesculinaires.security.config;

import com.recettes.miniprojet.recettesculinaires.services.impl.JWTAuthenticationEntryPoint;
import com.recettes.miniprojet.recettesculinaires.services.impl.JWTAuthenticationFilter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // PreAuthorize, PostAuthorize, PreFilter, and PostFilter
@SecurityScheme(
        name = "Bear Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
) // to pass token and authorized
@AllArgsConstructor
public class SecurityConfig {

    @Autowired private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private JWTAuthenticationFilter authenticationFilter;


    @Bean // automatically authenticate using userDetailsService and passwordEncoder without specify just injected
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(HttpMethod.POST,"/api/v1/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/v1/auth/register").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/**").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/v1/**").permitAll()
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                .anyRequest().permitAll()
                ).exceptionHandling(exception -> exception
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                ).sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}