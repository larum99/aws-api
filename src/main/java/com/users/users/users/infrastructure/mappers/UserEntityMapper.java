package com.users.users.users.infrastructure.mappers;

import com.users.users.users.domain.model.UserModel;
import com.users.users.users.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserModel entityToModel(UserEntity entity);
    UserEntity modelToEntity(UserModel model);

    default UserModel optionalEntityToModel(Optional<UserEntity> optionalEntity) {
        return optionalEntity.map(this::entityToModel).orElse(null);
    }
}
