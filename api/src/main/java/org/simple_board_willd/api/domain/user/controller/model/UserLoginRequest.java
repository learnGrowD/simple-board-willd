package org.simple_board_willd.api.domain.user.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
