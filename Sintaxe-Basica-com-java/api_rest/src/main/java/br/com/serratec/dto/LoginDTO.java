package br.com.serratec.dto;

public record LoginDTO(String email, String password) {

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }
    
}
