package com.CentralBookStore.Bookstore.Bookstore.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class LoginValidation {
    @ApiModelProperty(position = 0)
    private UUID id;
    @ApiModelProperty(position = 1)
    private String name;

    public LoginValidation(){
        this.id = UUID.fromString("00000000-0000-0000-0000-000000000000");
        this.name = "User_Not_Found";
    }

    public LoginValidation(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
