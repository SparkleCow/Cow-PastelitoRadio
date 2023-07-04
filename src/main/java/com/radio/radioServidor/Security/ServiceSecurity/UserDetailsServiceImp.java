package com.radio.radioServidor.Security.ServiceSecurity;

import com.radio.radioServidor.Entities.Users.RoleEntity;
import com.radio.radioServidor.Services.ServiceRepositoryUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.radio.radioServidor.Entities.Users.UserEntity;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

    private ServiceRepositoryUsers serviceRepositoryUsers;

    public UserDetailsServiceImp(ServiceRepositoryUsers  serviceRepositoryUsers){
        this.serviceRepositoryUsers = serviceRepositoryUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = serviceRepositoryUsers.findUser(username);
        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            return new User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public Collection<GrantedAuthority> getAuthorities(List<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}