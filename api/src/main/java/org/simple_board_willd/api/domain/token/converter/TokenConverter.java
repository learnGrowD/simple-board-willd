package org.simple_board_willd.api.domain.token.converter;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.annotation.Converter;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.token.controller.model.TokenResponse;
import org.simple_board_willd.api.domain.token.model.TokenDto;

import javax.persistence.Convert;
import java.util.Objects;

@RequiredArgsConstructor
@Converter
public class TokenConverter {

    public TokenResponse toResponse(
            TokenDto accessToken,
            TokenDto refreshToken
    ) {
        Objects.requireNonNull(accessToken, () -> {
            throw new ApiExeption(ErrorCode.NULL_POINT);
        });
        Objects.requireNonNull(refreshToken, () -> {
            throw new ApiExeption(ErrorCode.NULL_POINT);
        });

        return TokenResponse.builder()
                .accessToken(accessToken.getToken())
                .accessTokenExpiredAt(accessToken.getExpiredAt())
                .refreshToken(refreshToken.getToken())
                .refreshTokenExpiredAt(refreshToken.getExpiredAt())
                .build();
    }
}
