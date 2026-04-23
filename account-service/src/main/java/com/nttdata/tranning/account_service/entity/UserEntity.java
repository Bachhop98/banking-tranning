package com.nttdata.tranning.account_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone", length = 10)
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "status", length = 1)
    private String status;
    @Column(name = "is_delete", length = 1)
    private String isDelete;
    @Column(name = "create_date")
    private LocalDateTime createDate;;
}
