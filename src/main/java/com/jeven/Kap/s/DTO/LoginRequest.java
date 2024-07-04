package com.jeven.Kap.s.DTO;

public class LoginRequest {
    private String usernameorEmail;
    private String password;

    LoginRequest(){}

    public LoginRequest(String usernameorEmail, String password) {
        this.usernameorEmail = usernameorEmail;
        this.password = password;
    }

    public void setUsernameorEmail(String usernameorEmail) {
        this.usernameorEmail = usernameorEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsernameorEmail() {
        return usernameorEmail;
    }

    public String getPassword() {
        return password;
    }

    
}
