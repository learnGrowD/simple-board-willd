package org.simple_board_willd.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeIfs {

    USER_NOT_FOUND(400, 1404, "아이디 또는 비밀번호가 일치하지 않습니다."),
    USER_UNAGEGISTERD(400, 1405, "해지된 사용자 입니다.");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
