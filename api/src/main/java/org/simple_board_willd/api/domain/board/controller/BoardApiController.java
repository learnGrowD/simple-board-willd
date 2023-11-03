package org.simple_board_willd.api.domain.board.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.api.Api;
import org.simple_board_willd.api.domain.board.business.BoardBusiness;
import org.simple_board_willd.api.domain.board.controller.model.BoardCreateRequest;
import org.simple_board_willd.api.domain.board.controller.model.BoardResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardBusiness boardBusiness;
    @PostMapping("")
    public Api<BoardResponse> create(
            @Valid
            @RequestBody BoardCreateRequest request
    ) {
        var response = boardBusiness.create(request);
        return Api.OK(response);
    }
}
