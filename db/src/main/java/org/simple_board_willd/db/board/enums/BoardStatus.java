package org.simple_board_willd.db.board.enums;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BoardStatus {
    REGISTERED("등록"),
    UNREGISTERED("해지")
    ;

    private String description;
}
