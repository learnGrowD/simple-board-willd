package org.simple_board_willd.api.domain.token.ifs;

import antlr.Token;
import org.simple_board_willd.api.domain.token.model.TokenDto;

import java.util.Map;

public interface TokenHelperifs {
    TokenDto issueAccessToken(Map<String, Object> data);
    TokenDto issueRefeshToken(Map<String, Object> data);

    Map<String, Object> validationTokenWithThrow(String token);
}
