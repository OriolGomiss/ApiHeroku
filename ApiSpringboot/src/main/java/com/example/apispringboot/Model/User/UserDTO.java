package com.example.apispringboot.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String avatar;
    private String rol;

}
