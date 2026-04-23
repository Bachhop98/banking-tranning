package com.nttdata.tranning.transaction_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TransactionEntity {
    private String id;
    private String accountId;
    private String type;
    private Long amount;
    private String description;
    private String status;
    private String createdBy;
    private String createDate;
    private String modifiedBy;
    private String modifiedDate;
}
