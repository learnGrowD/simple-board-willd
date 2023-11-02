package org.simple_board_willd.api.domain.token.service;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.token.ifs.TokenHelperifs;
import org.simple_board_willd.api.domain.token.model.TokenDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenHelperifs tokenHelperifs;


    public TokenDto issueAccessToken(Long userId) {
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelperifs.issueAccessToken(data);
    }

    public TokenDto issueRefreshToken(Long userId) {
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelperifs.issueRefeshToken(data);
    }

    public Long validationToken(String token) {
        var map = tokenHelperifs.validationTokenWithThrow(token);
        var userId = map.get("userId");

        Objects.requireNonNull(userId, () -> { throw new ApiExeption(ErrorCode.NULL_POINT); });
        return Long.parseLong(userId.toString());
    }



}
