package com.users.users.users.domain.usecase;

import com.users.users.users.domain.exceptions.DuplicateDocumentException;
import com.users.users.users.domain.exceptions.MissingFieldException;
import com.users.users.users.domain.exceptions.UserAlreadyExistsException;
import com.users.users.users.domain.model.UserModel;
import com.users.users.users.domain.ports.in.UserServicePort;
import com.users.users.users.domain.ports.out.UserPersistencePort;
import com.users.users.users.domain.utils.DomainConstants;


public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void registerUser(UserModel userModel) {
        normalizeStringFields(userModel);
        validateMandatoryFields(userModel);
        checkIfDocumentAlreadyExists(userModel.getIdentityDocument());
        checkIfUserAlreadyExists(userModel.getEmail());

        userPersistencePort.saveUser(userModel);
    }

    @Override
    public UserModel getUserByDocument(String identityDocument) {
        return userPersistencePort.findByDocument(identityDocument);
    }

    @Override
    public UserModel getUserByEmail(String email) {
        return userPersistencePort.findByEmail(email);
    }

    private void normalizeStringFields(UserModel userModel) {
        userModel.setName(safeTrim(userModel.getName()));
        userModel.setEmail(safeTrim(userModel.getEmail()));
        userModel.setIdentityDocument(safeTrim(userModel.getIdentityDocument()));
    }

    private String safeTrim(String value) {
        return value == null ? null : value.trim();
    }

    private void validateMandatoryFields(UserModel userModel) {
        if (isBlank(userModel.getName())) {
            throw new MissingFieldException(DomainConstants.ERROR_REQUIRED_NAME);
        }
        if (isBlank(userModel.getEmail())) {
            throw new MissingFieldException(DomainConstants.ERROR_REQUIRED_EMAIL);
        }
        if (isBlank(userModel.getIdentityDocument())) {
            throw new MissingFieldException(DomainConstants.ERROR_REQUIRED_DOCUMENT);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private void checkIfDocumentAlreadyExists(String identityDocument) {
        if (userPersistencePort.findByDocument(identityDocument) != null) {
            throw new DuplicateDocumentException();
        }
    }

    private void checkIfUserAlreadyExists(String email) {
        if (userPersistencePort.findByEmail(email) != null) {
            throw new UserAlreadyExistsException();
        }
    }
}