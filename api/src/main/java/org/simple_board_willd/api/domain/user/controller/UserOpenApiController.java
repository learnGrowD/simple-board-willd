package org.simple_board_willd.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.api.Api;
import org.simple_board_willd.api.common.error.ErrorCode;
import org.simple_board_willd.api.common.exeption.ApiExeption;
import org.simple_board_willd.api.domain.token.controller.model.TokenResponse;
import org.simple_board_willd.api.domain.user.business.UserBusiness;
import org.simple_board_willd.api.domain.user.controller.model.UserLoginRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.ValidationException;

@RequiredArgsConstructor
@RestController
@Validated
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
    }

    //로그인
    @PostMapping("/login")
    public Api<TokenResponse> login(
            @Valid
            @RequestBody UserLoginRequest request
    ) {
        var response = userBusiness.login(request);
        return Api.OK(response);
    }
}
