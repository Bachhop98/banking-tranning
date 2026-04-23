package com.nttdata.tranning.transaction_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_entries")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AccountEntriesEntity {
    private String id;
    private String accountId;
    private String transactionId;
    private Long amount;
    private String entryType;
    private String createdBy;
    private String createDate;
    private String modifiedBy;
    private String modifiedDate;
}
