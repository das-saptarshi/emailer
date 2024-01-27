package com.saptarshi.das.usermanagementservice.service.impl;

import com.saptarshi.das.core.entity.User;
import com.saptarshi.das.core.entity.embeddable.Name;
import com.saptarshi.das.usermanagementservice.dto.request.UserCreationRequest;
import com.saptarshi.das.usermanagementservice.dto.response.UserResponse;
import com.saptarshi.das.usermanagementservice.repository.UserRepository;
import com.saptarshi.das.usermanagementservice.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    @Override
    public UserResponse createUser(@NonNull final UserCreationRequest request) {
        final User user = new User()
                .setName(new Name().setFirstName(request.getFirstName()).setLastName(request.getLastName()))
                .setEmail(request.getEmail())
                .setPassword(request.getPassword());

        this.userRepo.save(user);

        return new UserResponse()
                .setId(user.getId())
                .setName(user.getName().getFullName())
                .setEmail(user.getEmail());
    }
}
