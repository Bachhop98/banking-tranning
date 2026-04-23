package com.nttdata.tranning.account_service.controller;

import com.nttdata.tranning.account_service.dto.request.CreateUserRequestDTO;
import com.nttdata.tranning.account_service.dto.response.UserCreateResponseDTO;
import com.nttdata.tranning.account_service.dto.response.UserResponseDTO;
import com.nttdata.tranning.account_service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<UserCreateResponseDTO> createUser(@RequestBody CreateUserRequestDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
