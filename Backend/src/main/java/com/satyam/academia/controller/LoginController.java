package com.satyam.academia.controller;

import com.satyam.academia.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.satyam.academia.service.LoginService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        String token = loginService.loginEmployee(request);
        return ResponseEntity.ok(token);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidCredentials(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}
