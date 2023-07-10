package com.radio.radioServidor.Controllers;

import com.radio.radioServidor.Entities.Users.*;
import com.radio.radioServidor.Security.Jwt.JwtUtils;
import com.radio.radioServidor.Services.ServiceRepositoryRoles;
import com.radio.radioServidor.Services.ServiceRepositoryUsers;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;

/*
* Controlador para registrar y autenticar un usuario a través de JWT
*/
@RestController
public class UserController {

    private ServiceRepositoryUsers repositoryUsers;
    private ServiceRepositoryRoles respositoryRoles;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private JwtUtils jwtUtils;

    public UserController(JwtUtils jwtUtils, ServiceRepositoryRoles respositoryRoles, ServiceRepositoryUsers repositoryUsers, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder){
        this.respositoryRoles = respositoryRoles;
        this.repositoryUsers = repositoryUsers;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/api/createUser")
    public ResponseEntity<String> createUser(@RequestBody @Valid DataRequestUser dataRequestUser){
        if(repositoryUsers.existByUsername(dataRequestUser.username())){
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }else{
            RoleEntity role = respositoryRoles.findByName("USER").get();
            UserEntity user = UserEntity.builder()
                    .username(dataRequestUser.username())
                    .password(passwordEncoder.encode(dataRequestUser.password()))
                    .email(dataRequestUser.email())
                    .roles(Collections.singletonList(role))
                    .build();
            repositoryUsers.createUser(user);
            return ResponseEntity.ok("Usuario creado");
        }
    }

    @PostMapping("/api/createAdmin")
    public ResponseEntity<String> createAdmin(@RequestBody @Valid DataRequestUser dataRequestUser){
        if(repositoryUsers.existByUsername(dataRequestUser.username())){
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }else{
            RoleEntity role = respositoryRoles.findByName("ADMIN").get();
            UserEntity user = UserEntity.builder()
                    .username(dataRequestUser.username())
                    .password(passwordEncoder.encode(dataRequestUser.password()))
                    .email(dataRequestUser.email())
                    .roles(Collections.singletonList(role))
                    .build();
            repositoryUsers.createUser(user);
            return ResponseEntity.ok("Usuario creado");
        }
    }

    @PostMapping("/api/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid DataLoginUser dataLoginUser) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dataLoginUser.username(), dataLoginUser.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
