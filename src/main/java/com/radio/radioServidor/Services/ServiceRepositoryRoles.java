package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Users.RoleEntity;
import com.radio.radioServidor.Entities.Users.UserEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ServiceRepositoryRoles {

    public void createUser();
    public void deleteUser();
    public Optional<UserEntity> findUser();
    public void updateUser();
    public Optional<RoleEntity> findByName(String name);
}
