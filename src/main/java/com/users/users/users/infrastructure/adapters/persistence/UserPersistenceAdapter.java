package com.users.users.users.infrastructure.adapters.persistence;

import com.users.users.users.domain.model.UserModel;
import com.users.users.users.domain.ports.out.UserPersistencePort;
import com.users.users.users.infrastructure.entities.UserEntity;
import com.users.users.users.infrastructure.mappers.UserEntityMapper;
import com.users.users.users.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j

@Service
@Transactional
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void saveUser(UserModel userModel) {
        UserEntity entity = userEntityMapper.modelToEntity(userModel);
        userRepository.save(entity);
    }

    @Override
    public UserModel findByEmail(String email) {
        Optional<UserEntity> entity = userRepository.findByEmail(email);
        return userEntityMapper.optionalEntityToModel(entity);
    }

    @Override
    public UserModel findByDocument(String identityDocument) {
        Optional<UserEntity> entity = userRepository.findByIdentityDocument(identityDocument);
        return userEntityMapper.optionalEntityToModel(entity);
    }
}

