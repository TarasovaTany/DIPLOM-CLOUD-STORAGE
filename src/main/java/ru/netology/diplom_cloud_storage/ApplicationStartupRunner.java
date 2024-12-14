package ru.netology.diplom_cloud_storage;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.netology.diplom_cloud_storage.entity.UserEntity;
import ru.netology.diplom_cloud_storage.repository.UserRepository;

@AllArgsConstructor
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(UserEntity.builder().login("tany").password(passwordEncoder.encode("pass")).build());
        userRepository.save(UserEntity.builder().login("test_name").password(passwordEncoder.encode("#pass#")).build());
    }
}
