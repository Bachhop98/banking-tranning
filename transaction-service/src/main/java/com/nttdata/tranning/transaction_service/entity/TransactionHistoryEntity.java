package com.nttdata.tranning.transaction_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transaction_history")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TransactionHistoryEntity {
    private String id;
    private String accountId;
    private String transactionType;
    private Long amount;
    private Long balanceBefore;
    private Long balanceAfter;
    private String description;
    private String transactionId;
    private String status;
    private String relatedAccountId;
    private String createdBy;
    private String createDate;
    private String modifiedBy;
    private String modifiedDate;
}
