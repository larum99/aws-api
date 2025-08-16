package com.users.users.users.application.dto.request;

public record SaveUserRequest(
        String name,
        String email,
        String identityDocument
) {
}
