package org.simple_board_willd.api.domain.board.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateRequest {

    private Long boardId;

    private String boardName;

    private String content;
}
