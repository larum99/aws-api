package com.users.users.users.domain.ports.in;

import com.users.users.users.domain.model.UserModel;

public interface UserServicePort {

    void registerUser(UserModel userModel);

    UserModel getUserByDocument(String identityDocument);

    UserModel getUserByEmail(String email);
}