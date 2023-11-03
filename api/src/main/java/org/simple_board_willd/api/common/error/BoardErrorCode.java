package org.simple_board_willd.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardErrorCode implements ErrorCodeIfs{
    NO_DELETE_PERMISSION(400, 1504, "삭제 권한이 없습니다."),
    No_UPDATE_PERMISSION(400, 1505, "수정 권한이 없습니다.");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
