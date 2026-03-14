package com.mamun.authservice.controller;



import com.mamun.authservice.dto.LoginRequest;
import com.mamun.authservice.dto.RegisterRequest;
import com.mamun.authservice.dto.AuthResponse;
import com.mamun.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}