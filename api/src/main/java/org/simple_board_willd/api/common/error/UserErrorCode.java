package org.simple_board_willd.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeIfs {

    USER_NOT_FOUND(400, 1404, "사용자를 찾을수 없습니다.");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
