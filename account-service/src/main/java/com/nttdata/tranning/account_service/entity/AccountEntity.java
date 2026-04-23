package com.nttdata.tranning.account_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AccountEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "status", length = 1)
    private String status;
    @Column(name = "is_delete", length = 1)
    private String isDelete;
    @Column(name = "create_date")
    private LocalDateTime createDate;

}
