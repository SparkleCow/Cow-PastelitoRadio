package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Users.RoleEntity;
import com.radio.radioServidor.Entities.Users.UserEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ServiceRepositoryRoles {

    public Optional<RoleEntity> findByName(String name);
}
