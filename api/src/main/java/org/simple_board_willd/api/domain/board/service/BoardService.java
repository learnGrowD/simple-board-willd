package org.simple_board_willd.api.domain.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simple_board_willd.db.board.BoardEntity;
import org.simple_board_willd.db.board.BoardRepository;
import org.simple_board_willd.db.board.enums.BoardStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    //memberId
    //
    public BoardEntity create(BoardEntity entity) {
        entity.setStatus(BoardStatus.REGISTERED);
        entity.setPostedAt(LocalDateTime.now());
        return boardRepository.save(entity);
    }


}
