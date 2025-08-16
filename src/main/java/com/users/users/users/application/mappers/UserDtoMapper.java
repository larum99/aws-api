package com.users.users.users.application.mappers;

import com.users.users.users.application.dto.request.SaveUserRequest;
import com.users.users.users.application.dto.response.UserResponse;
import com.users.users.users.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {

    UserModel requestToModel(SaveUserRequest saveUserRequest);
    UserResponse modelToResponse(UserModel userModel);
}
