package org.simple_board_willd.api.domain.board.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simple_board_willd.db.User.Enums.UserStatus;
import org.simple_board_willd.db.User.Enums.UserType;
import org.simple_board_willd.db.board.enums.BoardStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponse {

    private Long userId;

    private Long boardId;

    private String userName;

    private String userEmail;

    private UserType userType;

    private UserStatus userStatus;

    private String boardName;

    private String boardContent;

    private BoardStatus boardStatus;

    private LocalDateTime postedAt;
}
