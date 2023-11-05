package org.simple_board_willd.api.domain.board.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateRequest {

    @NotEmpty(message = "어떠한 게시판인지 확일 할 수 없습니다.")
    private Long boardId;

    @NotEmpty(message = "게시판 이름을 입력해주세요.")
    private String boardName;

    private String content;
}
