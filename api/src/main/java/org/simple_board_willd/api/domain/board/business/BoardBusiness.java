package org.simple_board_willd.api.domain.board.business;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.annotation.Business;
import org.simple_board_willd.api.domain.board.controller.model.BoardCreateRequest;
import org.simple_board_willd.api.domain.board.controller.model.BoardResponse;
import org.simple_board_willd.api.domain.board.controller.model.BoardUpdateRequest;
import org.simple_board_willd.api.domain.board.converter.BoardConverter;
import org.simple_board_willd.api.domain.board.service.BoardService;
import org.simple_board_willd.db.board.BoardEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<BoardResponse> all() {
        return boardService.all().stream()
                .map(boardConverter::toResponse)
                .collect(Collectors.toList());
    }

    public BoardResponse detail(Long id) {
        var entity = boardService.detail(id);
        var result = boardConverter.toResponse(entity);
        return result;
    }

    public BoardResponse update(BoardUpdateRequest request) {
        var entity = boardService.update(request);
        var result = boardConverter.toResponse(entity);
        return result;
    }

    public BoardResponse delete(Long id) {
        var entity = boardService.delete(id);
        var result = boardConverter.toResponse(entity);
        return result;
    }

}
