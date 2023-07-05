package com.radio.radioServidor.Security.Configuration;

import com.radio.radioServidor.Security.Jwt.JwtAuthenticationFilter;
import com.radio.radioServidor.Security.Jwt.JwtAuthorityEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    public JwtAuthorityEntryPoint jwtAuthorityEntryPoint;
    public SecurityConfig(JwtAuthorityEntryPoint jwtAuthorityEntryPoint) {
        this.jwtAuthorityEntryPoint = jwtAuthorityEntryPoint;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(withDefaults())
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(jwtAuthorityEntryPoint))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/", "/index.html", "/login.html", "/register.html", "/podcast.html", "/weekSongs.html").permitAll()
                        .requestMatchers("api/songs", "/api/createUser", "/api/login", "/api/createAdmin").permitAll()
                        .requestMatchers("/api/songs/**").permitAll()
                        .requestMatchers("/Scripts/**", "/Styles/**", "/Imagenes/**", "/favicon.ico").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class).build();
    }
}
