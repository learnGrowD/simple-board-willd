package org.simple_board_willd.api.domain.user.converter;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.annotation.Converter;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserResponse;
import org.simple_board_willd.db.User.Enums.UserStatus;
import org.simple_board_willd.db.User.UserEntity;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Converter
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest request) {
        return UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress())
                .userType(request.getUserType())
                .build();
    }

    public UserResponse toResponse(UserEntity entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .userType(entity.getUserType())
                .status(entity.getStatus())
                .registeredAt(entity.getRegisteredAt())
                .unregisteredAt(entity.getUnregisteredAt())
                .lastLoginAt(entity.getLastLoginAt())
                .build();
    }
}
