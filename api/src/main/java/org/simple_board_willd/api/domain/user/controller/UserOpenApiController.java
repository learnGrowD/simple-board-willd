package org.simple_board_willd.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.api.Api;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.user.business.UserBusiness;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.ValidationException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/user")
public class UserOpenApiController {

    private final UserBusiness userBusiness;
    //회원가입
    @PostMapping("/register")
    public Api<UserResponse> register(
            @Valid
            @RequestBody UserRegisterRequest request
    ) {
        var resonse = userBusiness.register(request);
        return Api.OK(resonse);
//        try {
//
//        } catch (Exception e) {
//            if (e instanceof ValidationException) {
//                throw new ApiExeption(ErrorCode.SERVER_ERROR, "서버에러111!!");
//            } else {
//                throw new ApiExeption(ErrorCode.SERVER_ERROR, "서버에러222!!");
//            }
//
//        }
    }

    //로그인

}
