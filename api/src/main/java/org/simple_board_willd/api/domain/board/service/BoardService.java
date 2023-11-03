package org.simple_board_willd.api.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.db.board.BoardEntity;
import org.simple_board_willd.db.board.BoardRepository;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    //memberId
    //
    public BoardEntity create(BoardEntity entity) {
        return boardRepository.save(entity);
    }
}
