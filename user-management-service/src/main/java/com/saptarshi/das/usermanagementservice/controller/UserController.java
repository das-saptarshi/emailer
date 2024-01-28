package com.saptarshi.das.usermanagementservice.controller;

import com.saptarshi.das.core.dto.PaginationDTO;
import com.saptarshi.das.usermanagementservice.dto.request.UserCreationRequest;
import com.saptarshi.das.usermanagementservice.dto.response.UserResponse;
import com.saptarshi.das.usermanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public UserResponse createUser(@RequestBody final UserCreationRequest request) {
        return this.service.createUser(request);
    }

    @GetMapping
    public PaginationDTO<UserResponse> getUsers(
            @RequestParam(defaultValue = "0") final Integer page,
            @RequestParam(defaultValue = "10") final Integer size
    ) {
        return this.service.getUsers(page, size);
    }

    @GetMapping("/{user-id}")
    public UserResponse getUser(
            @PathVariable("user-id") final UUID userId
    ) {
        return this.service.getUser(userId);
    }
}
