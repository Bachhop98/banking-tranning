package com.nttdata.tranning.account_service.repository;

import com.nttdata.tranning.account_service.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user (id, full_name, email, phone, address, status, is_delete, create_date) VALUES (:#{#user.id}, :#{#user.fullName},:#{#user.email},:#{#user.phone}, :#{#user.address}, :#{#user.status}, :#{#user.isDelete}, :#{#user.createDate})", nativeQuery = true)
    void saveUser(@Param("user") UserEntity user);

    @Query(value = "SELECT user_name,full_name, email, phone, status FROM user WHERE id = id AND is_delete = '0')", nativeQuery = true)
    Optional<UserEntity> findById(@Param("id") String id);

    @Query(value = "SELECT user_name,full_name, email, phone, status FROM user WHERE user_name = userName AND is_delete = '0')", nativeQuery = true)
    Optional<UserEntity> findByUserName(@Param("userName") String userName);

}
