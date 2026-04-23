package com.nttdata.tranning.account_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateUserRequestDTO {
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String address;
}
