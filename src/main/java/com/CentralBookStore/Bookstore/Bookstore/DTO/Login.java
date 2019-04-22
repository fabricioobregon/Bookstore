package com.CentralBookStore.Bookstore.Bookstore.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Login {
    @ApiModelProperty(position = 0)
    private String password;
    @ApiModelProperty(position = 1)
    private String email;

    public Login(){}

    public Login(String password, String email) {
        this.password = password;
        this.email = email;
    }
}

