package com.radio.radioServidor.Services;

import com.radio.radioServidor.Entities.Users.UserEntity;
import com.radio.radioServidor.Repository.UsersRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ServiceRepositoryUsersImp implements ServiceRepositoryUsers{

    private UsersRepository usersRepository;

    ServiceRepositoryUsersImp(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        usersRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findUser(String username){
        return usersRepository.findByUsername(username);
    }

    @Override
    public boolean existByUsername(String username){
        return usersRepository.existsByUsername(username);
    }
}
