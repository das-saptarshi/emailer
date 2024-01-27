package com.saptarshi.das.usermanagementservice.service;

import com.saptarshi.das.usermanagementservice.dto.request.UserCreationRequest;
import com.saptarshi.das.usermanagementservice.dto.response.UserResponse;

public interface UserService {

    UserResponse createUser(UserCreationRequest request);
}
