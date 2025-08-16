package com.users.users.users.application.service.impl;

import com.users.users.users.application.dto.request.SaveUserRequest;
import com.users.users.users.application.dto.response.SaveUserResponse;
import com.users.users.users.application.dto.response.UserResponse;
import com.users.users.users.application.mappers.UserDtoMapper;
import com.users.users.users.application.service.UserService;
import com.users.users.users.application.utils.ApplicationConstants;
import com.users.users.users.domain.model.UserModel;
import com.users.users.users.domain.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServicePort userServicePort;
    private final UserDtoMapper userDtoMapper;

    @Override
    public SaveUserResponse saveUser(SaveUserRequest request) {
        UserModel userModel = userDtoMapper.requestToModel(request);
        userServicePort.registerUser(userModel);
        return new SaveUserResponse(ApplicationConstants.SAVE_USER_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public UserResponse getByEmail(String email) {
        UserModel model = userServicePort.getUserByEmail(email);
        return userDtoMapper.modelToResponse(model);
    }

    @Override
    public UserResponse getByDocument(String document) {
        UserModel model = userServicePort.getUserByDocument(document);
        return userDtoMapper.modelToResponse(model);
    }
}
