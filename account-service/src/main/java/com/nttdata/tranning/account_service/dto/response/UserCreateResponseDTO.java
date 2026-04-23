package com.nttdata.tranning.account_service.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserCreateResponseDTO {
    private String userName;
    private String accountNumber;
}
