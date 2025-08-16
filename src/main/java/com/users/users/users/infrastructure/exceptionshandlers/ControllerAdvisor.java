package com.users.users.users.infrastructure.exceptionshandlers;

import com.users.users.users.domain.exceptions.DuplicateDocumentException;
import com.users.users.users.domain.exceptions.MissingFieldException;
import com.users.users.users.domain.exceptions.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(
                ExceptionConstants.USER_ALREADY_EMAIL_EXISTS_MESSAGE,
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(DuplicateDocumentException.class)
    public ResponseEntity<ExceptionResponse> handleDuplicateDocument(DuplicateDocumentException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(
                ExceptionConstants.USER_ALREADY_DOCUMENTID_EXISTS_MESSAGE,
                LocalDateTime.now()
        ));
    }
    @ExceptionHandler(MissingFieldException.class)
    public ResponseEntity<ExceptionResponse> handleMissingField(MissingFieldException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(
                        ex.getMessage(),
                        LocalDateTime.now()
                ));
    }
}
