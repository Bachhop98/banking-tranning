package com.nttdata.tranning.account_service.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserResponseDTO {
    private String userName;
    private String fullName;
    private String phone;
    private String email;
    private String address;
}
