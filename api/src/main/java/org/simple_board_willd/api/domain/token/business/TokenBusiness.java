package org.simple_board_willd.api.domain.token.business;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.annotation.Business;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.token.controller.model.TokenResponse;
import org.simple_board_willd.api.domain.token.converter.TokenConverter;
import org.simple_board_willd.api.domain.token.service.TokenService;
import org.simple_board_willd.db.User.UserEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

    private final TokenService tokenService;
    private final TokenConverter tokenConverter;

    public TokenResponse issueToken(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(user -> {
                    var accessToken = tokenService.issueAccessToken(user.getId());
                    var refreshToken = tokenService.issueRefreshToken(user.getId());
                    return tokenConverter.toResponse(accessToken, refreshToken);
                })
                .orElseThrow(() -> {
                    throw new ApiExeption(ErrorCode.NULL_POINT);
                });

    }

    public Long validationAccessToken(String accessToken) {
        var userId = tokenService.validationToken(accessToken);
        return userId;
    }
}
