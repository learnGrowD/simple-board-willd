package org.simple_board_willd.api.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.simple_board_willd.api.common.api.Api;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = 0)
public class ValidationExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Api<Object>> validException(
            MethodArgumentNotValidException exception
    ) {
        log.error("", exception);

        return ResponseEntity
                .status(400)
                .body(Api.ERROR(ErrorCode.NULL_POINT, exception.getLocalizedMessage()));
    }
}
