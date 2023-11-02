package org.simple_board_willd.db.User.Enums;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserType {
    ADMIN("어드민"),
    COMMON("일반사용자")
    ;
    private final String description;
}
