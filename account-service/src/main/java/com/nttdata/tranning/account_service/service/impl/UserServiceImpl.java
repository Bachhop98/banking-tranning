package com.nttdata.tranning.account_service.service.impl;

import com.nttdata.tranning.account_service.dto.request.CreateUserRequestDTO;
import com.nttdata.tranning.account_service.dto.response.UserCreateResponseDTO;
import com.nttdata.tranning.account_service.dto.response.UserResponseDTO;
import com.nttdata.tranning.account_service.entity.AccountEntity;
import com.nttdata.tranning.account_service.entity.UserEntity;
import com.nttdata.tranning.account_service.repository.AccountRepository;
import com.nttdata.tranning.account_service.repository.UserRepository;
import com.nttdata.tranning.account_service.service.IUserService;
import com.nttdata.tranning.account_service.utils.AccountNumberGenerator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserCreateResponseDTO createUser(CreateUserRequestDTO request) {
        // 1. Validate
        if (userRepository.findByUserName(request.getUserName()).isPresent()) {
            throw new RuntimeException("Username exists");
        }
        UserEntity userEntity = UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .userName(request.getUserName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .fullName(request.getFullName())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .createDate(LocalDateTime.now())
                .status("1")
                .isDelete("0").build();
        userRepository.saveUser(userEntity);
        AccountEntity accountEntity = AccountEntity.builder()
                .id(UUID.randomUUID().toString())
                .userId(userEntity.getId())
                .accountNumber(AccountNumberGenerator.generate())
                .balance(BigDecimal.ZERO)
                .status("1")
                .isDelete("0")
                .createDate(LocalDateTime.now()).build();
        accountRepository.saveAccount(accountEntity);
        return UserCreateResponseDTO.builder()
                .accountNumber(accountEntity.getAccountNumber())
                .userName(userEntity.getUserName()).build();
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDTO getUserById(String id) {
        UserEntity entity = userRepository.findById(id).orElseThrow();
        return UserResponseDTO.builder()
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .fullName(entity.getFullName())
                .address(entity.getAddress()).build();
    }

    @Override
    public UserResponseDTO updateUser(String id, CreateUserRequestDTO dto) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }
}
