package com.CentralBookStore.Bookstore.Bookstore.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class LoginResponse {
    @ApiModelProperty(position = 0)
    private UUID id;
    @ApiModelProperty(position = 1)
    private String name;

    public LoginResponse(){
        this.id = UUID.fromString("00000000-0000-0000-0000-000000000000");
        this.name = "User_Not_Found";
    }

    public LoginResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
