package org.simple_board_willd.api.common.api;

import lombok.Getter;
import org.simple_board_willd.api.common.error.ErrorCodeIfs;

import javax.validation.Valid;

@Getter
public class Api<T> {
    private Result result;

    @Valid
    private T body;

    public static <T> Api<T> OK(T data) {
        var api = new Api<T>();
        api.result = Result.OK();
        api.body = data;
        return api;
    }

    public static Api<Object> ERROR(Result result) {
        var api = new Api<Object>();
        api.result = result;
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeIfs);
        return api;
    }
}
