package com.users.users.users.infrastructure.exceptionshandlers;

public class ExceptionConstants {

    private ExceptionConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String USER_ALREADY_EMAIL_EXISTS_MESSAGE = "Ya existe un usuario con este correo electrónico.";
    public static final String USER_ALREADY_DOCUMENTID_EXISTS_MESSAGE = "Ya existe un usuario con este documento.";
}
