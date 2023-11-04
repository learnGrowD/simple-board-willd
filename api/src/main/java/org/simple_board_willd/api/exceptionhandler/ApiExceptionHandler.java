package org.simple_board_willd.api.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.simple_board_willd.api.common.api.Api;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {
    @ExceptionHandler(value = ApiExeption.class)
    public ResponseEntity<Api<Object>> apiException(
            ApiExeption apiExeption
    ) {
        log.error("", apiExeption);

        var errorCode = apiExeption.getErrorCodeIfs();
        var description = apiExeption.getErrorDescription();

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(Api.ERROR(errorCode, description));
    }
}
