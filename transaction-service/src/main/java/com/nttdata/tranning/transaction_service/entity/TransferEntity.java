package com.nttdata.tranning.transaction_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TransferEntity {
    private String id;
    private String fromAccountId;
    private String toAccountId;
    private Long amount;
    private String status;
    private String createdBy;
    private String createDate;
    private String modifiedBy;
    private String modifiedDate;

}
