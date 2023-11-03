package org.simple_board_willd.api.domain.board.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.simple_board_willd.api.common.api.Api;
import org.simple_board_willd.api.domain.board.business.BoardBusiness;
import org.simple_board_willd.api.domain.board.controller.model.BoardCreateRequest;
import org.simple_board_willd.api.domain.board.controller.model.BoardResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @GetMapping("/all")
    public Api<List<BoardResponse>> all() {
        
    }

    @PostMapping("/{id}")
    public Api<BoardResponse> detail(@PathVariable Long boardId) {

    }

    @PutMapping("")
    public Api<BoardResponse> update(
            @Valid
            @RequestBody BoardCreateRequest request
    ) {

    }

    @DeleteMapping("/{id}")
    public Api<BoardResponse> delete(@PathVariable Long boardId) {

    }
}
