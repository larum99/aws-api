package com.users.users.users.application.service;

import com.users.users.users.application.dto.request.SaveUserRequest;
import com.users.users.users.application.dto.response.SaveUserResponse;
import com.users.users.users.application.dto.response.UserResponse;

public interface UserService {
    SaveUserResponse saveUser(SaveUserRequest request);
    UserResponse getByEmail(String email);
    UserResponse getByDocument(String document);
}
