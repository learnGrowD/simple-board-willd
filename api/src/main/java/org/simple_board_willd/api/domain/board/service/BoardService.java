package org.simple_board_willd.api.domain.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simple_board_willd.api.common.error.BoardErrorCode;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.board.controller.model.BoardUpdateRequest;
import org.simple_board_willd.api.domain.user.service.UserService;
import org.simple_board_willd.db.User.Enums.UserType;
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
    private final UserService userService;

    public BoardEntity create(BoardEntity entity) {
        entity.setStatus(BoardStatus.REGISTERED);
        entity.setPostedAt(LocalDateTime.now());
        return boardRepository.save(entity);
    }

    public BoardEntity detail(Long id) {
        var optionalBoardEntity = boardRepository.findById(id);
        var result = optionalBoardEntity.orElseThrow(() -> new ApiExeption(ErrorCode.NULL_POINT, "BoardEntity is null"));
        return result;
    }

    public List<BoardEntity> all() {
        return boardRepository.findAll();
    }

    public BoardEntity update(BoardUpdateRequest request) {
        var userEntity = userService.getUserEntity();
        var optionalBoardEntity = boardRepository.findById(request.getBoardId());
        var entity = optionalBoardEntity.orElseThrow(() -> new ApiExeption(ErrorCode.NULL_POINT, "BoardEntity is null"));
        if (userEntity.getId().equals(entity.getUserId())) {
            entity.setBoardName(request.getBoardName());
            entity.setContent(request.getContent());
            return boardRepository.save(entity);
        } else {
            throw new ApiExeption(BoardErrorCode.No_UPDATE_PERMISSION, "계정이 다른 계정임");
        }
    }

    public BoardEntity delete(Long boardId) {
        var userEntity = userService.getUserEntity();

        if (userEntity.getUserType().equals(UserType.ADMIN)) {
            var optionalEntity = boardRepository.findById(boardId);
            var entity = optionalEntity.orElseThrow(() -> new ApiExeption(ErrorCode.NULL_POINT, "Board Entity is null"));
            entity.setStatus(BoardStatus.UNREGISTERED);
            var result = boardRepository.save(entity);
            return result;
        } else {
            throw new ApiExeption(BoardErrorCode.NO_DELETE_PERMISSION, "어드민 계정이 아님.");
        }
    }
}
