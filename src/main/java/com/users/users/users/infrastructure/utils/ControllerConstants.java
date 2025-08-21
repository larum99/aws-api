package com.users.users.users.infrastructure.utils;

public class ControllerConstants {

    private ControllerConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String BASE_URL = "/api/v1/users";


    public static final String SAVE_PATH = "/save";

    public static final String GET_BY_EMAIL_PATH = "/email/{email}";

    public static final String GET_BY_DOCUMENT_PATH = "/document/{document}";

    public static final String TAG = "Usuarios";


    public static final String TAG_DESCRIPTION = "Operaciones relacionadas con los usuarios";
}
