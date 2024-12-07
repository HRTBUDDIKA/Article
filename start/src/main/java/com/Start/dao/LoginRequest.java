package com.Start.dao;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {

    @NotNull(message = "Email Is Required")
    private String email;
    @NotNull(message = "Password Is Required")
    private String password;
}
