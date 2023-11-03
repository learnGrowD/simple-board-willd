package org.simple_board_willd.api.common.api;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import io.swagger.v3.core.util.Json;
import lombok.Getter;
import org.simple_board_willd.api.common.error.ErrorCodeIfs;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

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
        api.body = new HashMap();
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeIfs);
        api.body = new HashMap();
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, String description) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeIfs, description);
        api.body = new HashMap();
        return api;
    }
}
