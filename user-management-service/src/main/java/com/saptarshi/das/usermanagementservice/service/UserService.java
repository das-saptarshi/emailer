package com.saptarshi.das.usermanagementservice.service;

import com.saptarshi.das.core.dto.PaginationDTO;
import com.saptarshi.das.usermanagementservice.dto.request.UserCreationRequest;
import com.saptarshi.das.usermanagementservice.dto.response.UserResponse;

import java.util.UUID;

public interface UserService {

    UserResponse createUser(UserCreationRequest request);

    PaginationDTO<UserResponse> getUsers(Integer page, Integer size);

    UserResponse getUser(UUID userId);
}
