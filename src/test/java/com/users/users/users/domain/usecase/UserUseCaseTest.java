package com.users.users.users.domain.usecase;

import com.users.users.users.domain.exceptions.DuplicateDocumentException;
import com.users.users.users.domain.exceptions.MissingFieldException;
import com.users.users.users.domain.exceptions.UserAlreadyExistsException;
import com.users.users.users.domain.model.UserModel;
import com.users.users.users.domain.ports.out.UserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    @Mock
    private UserPersistencePort userPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    private UserModel userModel;

    @BeforeEach
    void setUp() {
        userModel = new UserModel();
        userModel.setName("John Doe");
        userModel.setEmail("john.doe@example.com");
        userModel.setIdentityDocument("123456789");
    }

    @Test
    void should_register_user_successfully() {
        // Arrange
        when(userPersistencePort.findByDocument(userModel.getIdentityDocument())).thenReturn(null);
        when(userPersistencePort.findByEmail(userModel.getEmail())).thenReturn(null);

        // Act
        userUseCase.registerUser(userModel);

        // Assert
        verify(userPersistencePort, times(1)).saveUser(userModel);
    }

    @Test
    void should_throw_exception_when_user_email_already_exists() {
        // Arrange
        when(userPersistencePort.findByDocument(userModel.getIdentityDocument())).thenReturn(null);
        when(userPersistencePort.findByEmail(userModel.getEmail())).thenReturn(userModel);

        // Act & Assert
        assertThrows(UserAlreadyExistsException.class, () -> userUseCase.registerUser(userModel));
        verify(userPersistencePort, never()).saveUser(any(UserModel.class));
    }

    @Test
    void should_throw_exception_when_document_already_exists() {
        // Arrange
        when(userPersistencePort.findByDocument(userModel.getIdentityDocument())).thenReturn(userModel);

        // Act & Assert
        assertThrows(DuplicateDocumentException.class, () -> userUseCase.registerUser(userModel));
        verify(userPersistencePort, never()).saveUser(any(UserModel.class));
    }

    @Test
    void should_throw_exception_when_name_is_missing() {
        // Arrange
        userModel.setName(null);

        // Act & Assert
        assertThrows(MissingFieldException.class, () -> userUseCase.registerUser(userModel));
        verify(userPersistencePort, never()).saveUser(any(UserModel.class));
    }

}