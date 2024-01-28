package com.saptarshi.das.usermanagementservice.service.impl;

import com.saptarshi.das.core.dto.PaginationDTO;
import com.saptarshi.das.core.entity.User;
import com.saptarshi.das.core.entity.embeddable.Name;
import com.saptarshi.das.usermanagementservice.dto.request.UserCreationRequest;
import com.saptarshi.das.usermanagementservice.dto.response.UserResponse;
import com.saptarshi.das.usermanagementservice.repository.UserRepository;
import com.saptarshi.das.usermanagementservice.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

        return this.convertUserEntityToResponse(user);
    }


    @Override
    public PaginationDTO<UserResponse> getUsers(
            @NonNull final Integer page,
            @NonNull final Integer size
    ) {
        final Pageable pageable = PageRequest.of(page, size);
        final Page<User> records = this.userRepo.findAll(pageable);

        return new PaginationDTO<UserResponse>()
                .setRecords(records.get().map(this::convertUserEntityToResponse).toList())
                .setTotalRecords(records.getTotalElements());
    }

    @Override
    public UserResponse getUser(@NonNull final UUID userId) {
        final User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));
        return this.convertUserEntityToResponse(user);
    }

    private UserResponse convertUserEntityToResponse(@NonNull final User user) {
        return new UserResponse()
                .setId(user.getId())
                .setName(user.getName().getFullName())
                .setEmail(user.getEmail());
    }
}
