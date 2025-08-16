package com.users.users.commons.configurations.beans;


import com.users.users.users.domain.ports.in.UserServicePort;
import com.users.users.users.domain.ports.out.UserPersistencePort;
import com.users.users.users.domain.usecase.UserUseCase;
import com.users.users.users.infrastructure.adapters.persistence.UserPersistenceAdapter;
import com.users.users.users.infrastructure.mappers.UserEntityMapper;
import com.users.users.users.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeansConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(
                userPersistencePort()
        );
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }
}
