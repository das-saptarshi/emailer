package com.saptarshi.das.usermanagementservice.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
}
