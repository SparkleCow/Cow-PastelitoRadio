package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Users.UserEntity;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ServiceRepositoryUsers {

    public void createUser(UserEntity userEntity);
    public Optional<UserEntity> findUser(String username);
    public boolean existByUsername(String username);
}
