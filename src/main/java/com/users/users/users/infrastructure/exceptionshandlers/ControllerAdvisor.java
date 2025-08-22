package com.users.users.users.infrastructure.exceptionshandlers;

import com.users.users.users.domain.exceptions.DuplicateDocumentException;
import com.users.users.users.domain.exceptions.MissingFieldException;
import com.users.users.users.domain.exceptions.UserAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    private static final Logger log = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        String logMessage = "Se intentó registrar un usuario con un email duplicado.";
        log.error("UserAlreadyExistsException: {}", logMessage);

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(
                        ExceptionConstants.USER_ALREADY_EMAIL_EXISTS_MESSAGE,
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(DuplicateDocumentException.class)
    public ResponseEntity<ExceptionResponse> handleDuplicateDocument(DuplicateDocumentException ex) {
        String logMessage = "Se intentó registrar un usuario con un documento duplicado.";
        log.error("DuplicateDocumentException: {}", logMessage);

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(
                        ExceptionConstants.USER_ALREADY_DOCUMENTID_EXISTS_MESSAGE,
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(MissingFieldException.class)
    public ResponseEntity<ExceptionResponse> handleMissingField(MissingFieldException ex) {
        log.error("MissingFieldException: {}", ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(
                        ex.getMessage(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException(Exception ex) {
        log.error("Unhandled exception: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(
                        "Error interno en el servidor",
                        LocalDateTime.now()
                ));
    }
}