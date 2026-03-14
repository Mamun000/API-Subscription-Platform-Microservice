package com.mamun.authservice.dto;

import com.mamun.authservice.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String password;
    private Role role;

}