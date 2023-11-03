package org.simple_board_willd.api.common.exeption;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.simple_board_willd.api.common.error.ErrorCodeIfs;

@Getter
public class ApiExeption extends RuntimeException implements ApiExeptionIfs {
    private final ErrorCodeIfs errorCodeIfs;
    private final String errorDescription;

    public ApiExeption(ErrorCodeIfs errorCodeIfs) {
        super(errorCodeIfs.getDescription());
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();
    }

    public ApiExeption(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = tx.getLocalizedMessage();
    }

    public ApiExeption(ErrorCodeIfs errorCodeIfs, String errorDescription) {
        super(errorDescription);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorDescription;
    }
}
