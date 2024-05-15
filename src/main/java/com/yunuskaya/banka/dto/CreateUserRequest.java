package com.yunuskaya.banka.dto;

import com.yunuskaya.banka.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String job;
    private String username;
    private String password;
    Set<Role> authorities;

}