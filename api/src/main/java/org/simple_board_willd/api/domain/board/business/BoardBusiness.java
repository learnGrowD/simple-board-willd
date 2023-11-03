package org.simple_board_willd.api.domain.board.business;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.annotation.Business;
import org.simple_board_willd.api.domain.board.controller.model.BoardCreateRequest;
import org.simple_board_willd.api.domain.board.controller.model.BoardResponse;
import org.simple_board_willd.api.domain.board.converter.BoardConverter;
import org.simple_board_willd.api.domain.board.service.BoardService;

@RequiredArgsConstructor
@Business
public class BoardBusiness {

    private final BoardService boardService;
    private final BoardConverter boardConverter;


    public BoardResponse create(BoardCreateRequest request) {
        var boardEntity = boardConverter.toEntity(request);
        var newEntity = boardService.create(boardEntity);
        var result = boardConverter.toResponse(newEntity);
        return result;
    }

}
