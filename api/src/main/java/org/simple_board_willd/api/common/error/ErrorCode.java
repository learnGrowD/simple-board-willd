package org.simple_board_willd.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeIfs {
    OK(200, 200, "성공"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"),
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST.value(), 510, "Validation Exception"),
    NULL_POINT(HttpStatus.BAD_REQUEST.value(), 512, "Null point"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버에러");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;

}