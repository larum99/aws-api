package com.users.users.users.infrastructure.endpoints.rest;

import com.users.users.users.application.dto.request.SaveUserRequest;
import com.users.users.users.application.dto.response.SaveUserResponse;
import com.users.users.users.application.dto.response.UserResponse;
import com.users.users.users.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<SaveUserResponse> saveUser(@RequestBody SaveUserRequest request) {
        return new ResponseEntity<>(userService.saveUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @GetMapping("/document/{document}")
    public ResponseEntity<UserResponse> getByDocument(@PathVariable String document) {
        return ResponseEntity.ok(userService.getByDocument(document));
    }
}
