package com.users.users.users.domain.ports.out;

import com.users.users.users.domain.model.UserModel;

public interface UserPersistencePort {

    void saveUser(UserModel userModel);

    UserModel findByEmail(String email);

    UserModel findByDocument(String identityDocument);
}