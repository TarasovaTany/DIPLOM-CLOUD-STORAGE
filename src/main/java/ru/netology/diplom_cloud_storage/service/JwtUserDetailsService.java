package ru.netology.diplom_cloud_storage.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.diplom_cloud_storage.entity.UserEntity;
import ru.netology.diplom_cloud_storage.repository.UserRepository;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User \"%s\" not found!", login)));
        return new User(userEntity.getLogin(), userEntity.getPassword(), new ArrayList<>());
    }
}