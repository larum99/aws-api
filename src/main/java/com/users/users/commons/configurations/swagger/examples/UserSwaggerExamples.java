package com.users.users.commons.configurations.swagger.examples;

public class UserSwaggerExamples {

    private UserSwaggerExamples() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CREATE_USER_REQUEST = """
        {
           "name": "Juan Pérez",
           "email": "juan.perez@example.com",
           "identityDocument": "123456789"
        }
    """;

    public static final String USER_CREATED_RESPONSE = """
        {
          "message": "Usuario creado correctamente.",
          "time": "2025-08-17T10:00:00"
        }
    """;

    public static final String USER_ALREADY_EXISTS_RESPONSE = """
        {
          "message": "El usuario con ese correo o documento ya existe.",
          "time": "2025-08-17T10:05:00"
        }
    """;

    public static final String USER_BY_EMAIL_RESPONSE = """
        {
          "id": 1,
          "email": "juan.perez@example.com",
          "identityDocument": "123456789",
          "name": "Juan Pérez"
        }
    """;

    public static final String USER_BY_DOCUMENT_RESPONSE = """
        {
          "id": 2,
          "email": "laura.gomez@example.com",
          "identityDocument": "987654321",
          "name": "Laura Gómez"
        }
    """;

    public static final String USER_NOT_FOUND_RESPONSE = """
        {
          "message": "Usuario no encontrado.",
          "httpStatus": "NOT_FOUND"
        }
    """;
}
