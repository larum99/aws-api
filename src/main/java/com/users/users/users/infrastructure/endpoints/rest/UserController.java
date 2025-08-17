package com.users.users.users.infrastructure.endpoints.rest;

import com.users.users.commons.configurations.swagger.docs.UserControllerDocs.*;
import com.users.users.users.application.dto.request.SaveUserRequest;
import com.users.users.users.application.dto.response.SaveUserResponse;
import com.users.users.users.application.dto.response.UserResponse;
import com.users.users.users.application.service.UserService;
import com.users.users.users.infrastructure.utils.ControllerConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerConstants.BASE_URL)
@RequiredArgsConstructor
@Tag(name = ControllerConstants.TAG, description = ControllerConstants.TAG_DESCRIPTION)
public class UserController {

    private final UserService userService;

    @CreateUserDocs
    @PostMapping(ControllerConstants.SAVE_PATH)
    public ResponseEntity<SaveUserResponse> saveUser(@RequestBody SaveUserRequest request) {
        return new ResponseEntity<>(userService.saveUser(request), HttpStatus.CREATED);
    }

    @GetUserByEmailDocs
    @GetMapping(ControllerConstants.GET_BY_EMAIL_PATH)
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @GetUserByDocumentDocs
    @GetMapping(ControllerConstants.GET_BY_DOCUMENT_PATH)
    public ResponseEntity<UserResponse> getByDocument(@PathVariable String document) {
        return ResponseEntity.ok(userService.getByDocument(document));
    }
}
