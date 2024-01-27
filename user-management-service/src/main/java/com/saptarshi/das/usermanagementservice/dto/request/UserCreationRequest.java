package com.saptarshi.das.usermanagementservice.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserCreationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
