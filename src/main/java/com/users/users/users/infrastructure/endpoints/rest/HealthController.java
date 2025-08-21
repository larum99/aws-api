package com.users.users.users.infrastructure.endpoints.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<String> health() {
        // Solo responde OK, suficiente para el ALB
        return ResponseEntity.ok("OK");
    }
}
