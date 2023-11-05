package org.simple_board_willd.api.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.error.UserErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.user.controller.model.UserLoginRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.db.User.Enums.UserStatus;
import org.simple_board_willd.db.User.UserEntity;
import org.simple_board_willd.db.User.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity register(UserEntity entity) {
        var newEntity = Optional.ofNullable(entity).map(it -> {
            it.setRegisteredAt(LocalDateTime.now());
            it.setStatus(UserStatus.REGISTERD);
            return it;
        }).orElseThrow(() -> {
            throw new ApiExeption(ErrorCode.NULL_POINT, "UserEntity is null");
        });
        return userRepository.save(newEntity);
    }

    public UserEntity login(UserLoginRequest request) {
        var optionalUserEntity = userRepository.findFirstByEmailAndPasswordOrderByIdDesc(request.getEmail(), request.getPassword());
        var entity = optionalUserEntity.orElseThrow(() -> new ApiExeption(UserErrorCode.USER_NOT_FOUND, "UserEntity is null"));
        if (entity.getStatus() == UserStatus.UNREGISTERED) {
            throw new ApiExeption(UserErrorCode.USER_UNAGEGISTERD);
        }
        return entity;
    }

    public UserEntity getUserEntity() {
        var userId = RequestContextHolder.getRequestAttributes().getAttribute("userId", RequestAttributes.SCOPE_REQUEST);
        var userEntity = userRepository.findById(Long.parseLong(userId.toString()));
        return userEntity.orElseThrow(() -> new ApiExeption(UserErrorCode.USER_NOT_FOUND));
    }
}
