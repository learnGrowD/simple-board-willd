package org.simple_board_willd.api.domain.user.business;

import lombok.AllArgsConstructor;
import org.simple_board_willd.api.common.annotation.Business;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserResponse;
import org.simple_board_willd.api.domain.user.converter.UserConverter;
import org.simple_board_willd.api.domain.user.service.UserService;

@AllArgsConstructor
@Business
public class UserBusiness {

    private final UserService userService;
    private final UserConverter userConverter;

    //
    public UserResponse register(UserRegisterRequest request) {
        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var result = userConverter.toResponse(newEntity);
        return  result;
    }
}
