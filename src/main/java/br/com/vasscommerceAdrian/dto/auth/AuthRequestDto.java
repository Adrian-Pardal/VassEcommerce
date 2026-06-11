package br.com.vasscommerceAdrian.dto.auth;

import jakarta.validation.constraints.NotBlank;

public class AuthRequestDto { // Se preferir, renomeie o arquivo para LoginRequest

    @NotBlank
    private String username; // Alterado de login para username

    @NotBlank
    private String password; // Alterado de senha para password

    public AuthRequestDto() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}