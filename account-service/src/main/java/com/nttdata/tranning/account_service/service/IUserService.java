package com.nttdata.tranning.account_service.service;

import com.nttdata.tranning.account_service.dto.request.CreateUserRequestDTO;
import com.nttdata.tranning.account_service.dto.response.UserCreateResponseDTO;
import com.nttdata.tranning.account_service.dto.response.UserResponseDTO;

import java.util.List;

public interface IUserService {
    UserCreateResponseDTO createUser(CreateUserRequestDTO dto);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(String id);
    UserResponseDTO updateUser(String id, CreateUserRequestDTO dto);
    void deleteUser(String id);

//    TokenExchangeResponse login(LoginRequestDto dto);
}
