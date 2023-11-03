package org.simple_board_willd.api.domain.board.converter;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.annotation.Converter;
import org.simple_board_willd.api.domain.token.business.TokenBusiness;
import org.simple_board_willd.db.board.BoardEntity;

@RequiredArgsConstructor
@Converter
public class BoardConverter {

    private final TokenBusiness tokenBusiness;

    public BoardEntity toEntity() {

    }
    
    public
}
