package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Users.RoleEntity;
import com.radio.radioServidor.Entities.Users.UserEntity;
import com.radio.radioServidor.Repository.RolesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceRepositoryRolesImp implements ServiceRepositoryRoles {
    private RolesRepository rolesRepository;
    public ServiceRepositoryRolesImp(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }
    @Override
    public void createUser() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public Optional<UserEntity> findUser() {
        return Optional.empty();
    }

    @Override
    public void updateUser() {

    }

    @Override
    public Optional<RoleEntity> findByName(String name) {
        return rolesRepository.findByName(name);
    }
}
