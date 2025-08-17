package com.users.users.commons.configurations.swagger.docs;

public class SwaggerConstants {

    private SwaggerConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String APPLICATION_JSON = "application/json";

    public static final String CREATED = "201";
    public static final String OK = "200";
    public static final String BAD_REQUEST = "400";
    public static final String NOT_FOUND = "404";

    public static final String SUMMARY_CREATE_USER = "Crear un nuevo usuario";
    public static final String DESCRIPTION_CREATE_USER = "Registra un nuevo usuario en el sistema.";
    public static final String REQUEST_BODY_CREATE_USER = "Objeto con los datos necesarios para crear un usuario.";
    public static final String DESCRIPTION_CREATE_USER_SUCCESS = "Usuario creado exitosamente.";
    public static final String DESCRIPTION_USER_ALREADY_EXISTS = "El usuario ya existe en el sistema.";

    public static final String SUMMARY_GET_BY_EMAIL = "Obtener usuario por correo electrónico";
    public static final String DESCRIPTION_GET_BY_EMAIL = "Retorna un usuario a partir de su dirección de correo electrónico.";
    public static final String DESCRIPTION_GET_BY_EMAIL_SUCCESS = "Usuario encontrado por correo electrónico.";
    public static final String DESCRIPTION_EMAIL_NOT_FOUND = "No se encontró un usuario con ese correo.";

    public static final String SUMMARY_GET_BY_DOCUMENT = "Obtener usuario por documento";
    public static final String DESCRIPTION_GET_BY_DOCUMENT = "Retorna un usuario a partir de su número de documento.";
    public static final String DESCRIPTION_GET_BY_DOCUMENT_SUCCESS = "Usuario encontrado por documento.";
    public static final String DESCRIPTION_DOCUMENT_NOT_FOUND = "No se encontró un usuario con ese documento.";

    public static final String EXAMPLE_NAME_CREATE_REQUEST = "Ejemplo de creación de usuario";
    public static final String EXAMPLE_NAME_SUCCESS = "Respuesta exitosa";
    public static final String EXAMPLE_NAME_ERROR = "Respuesta de error";
}
