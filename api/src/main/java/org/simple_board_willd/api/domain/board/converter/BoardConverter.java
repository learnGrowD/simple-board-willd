package org.simple_board_willd.api.domain.board.converter;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.annotation.Converter;
import org.simple_board_willd.api.domain.board.controller.model.BoardCreateRequest;
import org.simple_board_willd.api.domain.board.controller.model.BoardResponse;
import org.simple_board_willd.api.domain.token.business.TokenBusiness;
import org.simple_board_willd.api.domain.user.business.UserBusiness;
import org.simple_board_willd.api.domain.user.service.UserService;
import org.simple_board_willd.db.User.UserRepository;
import org.simple_board_willd.db.board.BoardEntity;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@RequiredArgsConstructor
@Converter
public class BoardConverter {

    private final UserService userService;

    public BoardEntity toEntity(BoardCreateRequest request) {
        return BoardEntity.builder()
                .boardName(request.getBoardName())
                .content(request.getContent())
                .build();
    }

    public BoardResponse toResponse(BoardEntity entity) {
        var userEntity = userService.getUserEntity();

        return BoardResponse.builder()
                .userId(userEntity.getId())
                .userName(userEntity.getName())
                .userEmail(userEntity.getEmail())
                .userStatus(userEntity.getStatus())
                .userType(userEntity.getUserType())
                .boardId(entity.getId())
                .boardName(entity.getBoardName())
                .boardContent(entity.getContent())
                .boardStatus(entity.getStatus())
                .build();
    }
}
