package com.CentralBookStore.Bookstore.Bookstore.DTO;

import lombok.Data;

@Data
public class Login {
    private String password;
    private String email;

    public Login(){}

    public Login(String password, String email) {
        this.password = password;
        this.email = email;
    }
}

