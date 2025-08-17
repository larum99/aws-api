package com.users.users.commons.configurations.swagger.docs;


import com.users.users.commons.configurations.swagger.examples.UserSwaggerExamples;
import com.users.users.users.application.dto.request.SaveUserRequest;
import com.users.users.users.application.dto.response.SaveUserResponse;
import com.users.users.users.application.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

import static com.users.users.commons.configurations.swagger.docs.SwaggerConstants.*;

public class UserControllerDocs {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(
            summary = SUMMARY_CREATE_USER,
            description = DESCRIPTION_CREATE_USER,
            requestBody = @RequestBody(
                    description = REQUEST_BODY_CREATE_USER,
                    required = true,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            schema = @Schema(implementation = SaveUserRequest.class),
                            examples = @ExampleObject(
                                    name = EXAMPLE_NAME_CREATE_REQUEST,
                                    value = UserSwaggerExamples.CREATE_USER_REQUEST
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = CREATED, description = DESCRIPTION_CREATE_USER_SUCCESS,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            schema = @Schema(implementation = SaveUserResponse.class),
                            examples = @ExampleObject(
                                    name = EXAMPLE_NAME_SUCCESS,
                                    value = UserSwaggerExamples.USER_CREATED_RESPONSE
                            )
                    )
            ),
            @ApiResponse(responseCode = BAD_REQUEST, description = DESCRIPTION_USER_ALREADY_EXISTS,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            examples = @ExampleObject(
                                    name = EXAMPLE_NAME_ERROR,
                                    value = UserSwaggerExamples.USER_ALREADY_EXISTS_RESPONSE
                            )
                    )
            )
    })
    public @interface CreateUserDocs {}

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(
            summary = SUMMARY_GET_BY_EMAIL,
            description = DESCRIPTION_GET_BY_EMAIL
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = OK, description = DESCRIPTION_GET_BY_EMAIL_SUCCESS,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            schema = @Schema(implementation = UserResponse.class),
                            examples = @ExampleObject(
                                    name = EXAMPLE_NAME_SUCCESS,
                                    value = UserSwaggerExamples.USER_BY_EMAIL_RESPONSE
                            )
                    )
            ),
            @ApiResponse(responseCode = NOT_FOUND, description = DESCRIPTION_EMAIL_NOT_FOUND,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            examples = @ExampleObject(
                                    name = EXAMPLE_NAME_ERROR,
                                    value = UserSwaggerExamples.USER_NOT_FOUND_RESPONSE
                            )
                    )
            )
    })
    public @interface GetUserByEmailDocs {}

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(
            summary = SUMMARY_GET_BY_DOCUMENT,
            description = DESCRIPTION_GET_BY_DOCUMENT
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = OK, description = DESCRIPTION_GET_BY_DOCUMENT_SUCCESS,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            schema = @Schema(implementation = UserResponse.class),
                            examples = @ExampleObject(
                                    name = EXAMPLE_NAME_SUCCESS,
                                    value = UserSwaggerExamples.USER_BY_DOCUMENT_RESPONSE
                            )
                    )
            ),
            @ApiResponse(responseCode = NOT_FOUND, description = DESCRIPTION_DOCUMENT_NOT_FOUND,
                    content = @Content(
                            mediaType = APPLICATION_JSON,
                            examples = @ExampleObject(
                                    name = EXAMPLE_NAME_ERROR,
                                    value = UserSwaggerExamples.USER_NOT_FOUND_RESPONSE
                            )
                    )
            )
    })
    public @interface GetUserByDocumentDocs {}
}

