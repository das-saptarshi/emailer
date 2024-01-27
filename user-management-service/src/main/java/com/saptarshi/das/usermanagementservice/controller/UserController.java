package com.saptarshi.das.usermanagementservice.controller;

import com.saptarshi.das.usermanagementservice.dto.request.UserCreationRequest;
import com.saptarshi.das.usermanagementservice.dto.response.UserResponse;
import com.saptarshi.das.usermanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public UserResponse createUser(@RequestBody final UserCreationRequest request) {
        return service.createUser(request);
    }
}
