package org.simple_board_willd.db.User.Enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {

    REGISTERD("등록"),
    UNREGISTERED("해지");

    private final String description;
}
