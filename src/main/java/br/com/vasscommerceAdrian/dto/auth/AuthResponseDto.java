package br.com.vasscommerceAdrian.dto.auth;

public class AuthResponseDto {

    private String token;
    private String tipo = "Bearer";

    public AuthResponseDto(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
