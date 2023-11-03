package org.simple_board_willd.api.domain.user.business;

import lombok.AllArgsConstructor;
import org.simple_board_willd.api.common.annotation.Business;
import org.simple_board_willd.api.domain.token.business.TokenBusiness;
import org.simple_board_willd.api.domain.token.controller.model.TokenResponse;
import org.simple_board_willd.api.domain.user.controller.model.UserLoginRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserResponse;
import org.simple_board_willd.api.domain.user.converter.UserConverter;
import org.simple_board_willd.api.domain.user.service.UserService;

@AllArgsConstructor
@Business
public class UserBusiness {

    private final UserService userService;
    private final UserConverter userConverter;
    private final TokenBusiness tokenBusiness;

    //
    public UserResponse register(UserRegisterRequest request) {
        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var result = userConverter.toResponse(newEntity);
        return  result;
    }

    public TokenResponse login(UserLoginRequest request) {
        var userEntity = userService.login(request);
        var result = tokenBusiness.issueToken(userEntity);
        return result;
    }
}
