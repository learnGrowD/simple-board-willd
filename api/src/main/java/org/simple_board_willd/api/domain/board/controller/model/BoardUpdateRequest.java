package org.simple_board_willd.api.domain.board.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateRequest {

    @NotNull
    private Long boardId;

    @NotEmpty(message = "게시판 이름을 입력해주세요.")
    private String boardName;

    private String content;
}
