package com.nttdata.tranning.account_service.repository;

import com.nttdata.tranning.account_service.entity.AccountEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO account (id, user_id, account_number, account_type, balance, status, is_delete, create_date) VALUES (:#{#account.id}, :#{#account.userId},:#{#account.accountNumber},:#{#account.accountType}, :#{#account.balance}, :#{#account.status}, :#{#account.isDelete},:#{#account.createDate})", nativeQuery = true)
    void saveAccount(@Param("account") AccountEntity account );

    @Query(value = "SELECT user_id, account_number, account_type, balance, status FROM account WHERE  is_delete = '0')", nativeQuery = true)
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}
