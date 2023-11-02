package org.simple_board_willd.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.api.Api;
import org.simple_board_willd.api.domain.user.business.UserBusiness;
import org.simple_board_willd.api.domain.user.controller.model.UserRegisterRequest;
import org.simple_board_willd.api.domain.user.controller.model.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        System.out.println("이거 뭔지 반드시 확인" + request);
        var resonse = userBusiness.register(request);
        return Api.OK(resonse);
    }

    //로그인

}
