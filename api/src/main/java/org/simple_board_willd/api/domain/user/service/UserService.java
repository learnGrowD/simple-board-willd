package org.simple_board_willd.api.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.db.User.Enums.UserStatus;
import org.simple_board_willd.db.User.UserEntity;
import org.simple_board_willd.db.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //회원가입 하기
    public UserEntity register(UserEntity entity) {
        var newEntity = Optional.ofNullable(entity).map( it -> {
            it.setRegisteredAt(LocalDateTime.now());
            it.setStatus(UserStatus.REGISTERD);
            return it;
        }).orElseThrow( () -> {throw new ApiExeption(ErrorCode.NULL_POINT, "UserEntity is null");});
        return userRepository.save(newEntity);
    }
}
