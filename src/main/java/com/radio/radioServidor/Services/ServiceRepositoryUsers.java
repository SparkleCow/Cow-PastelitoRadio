package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Users.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepositoryUsers {

    public void createUser(UserEntity userEntity);
    public void deleteUser();
    public Optional<UserEntity> findUser(String username);
    public void updateUser();
    public boolean existByUsername(String username);
}
