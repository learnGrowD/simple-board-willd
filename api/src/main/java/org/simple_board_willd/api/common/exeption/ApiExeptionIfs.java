package org.simple_board_willd.api.common.exeption;

import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.error.ErrorCodeIfs;

public interface ApiExeptionIfs {

    ErrorCodeIfs getErrorCodeIfs();
    String getErrorDescription();
}
