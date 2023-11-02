package org.simple_board_willd.api.domain.user.controller.model;

import lombok.*;
import org.simple_board_willd.db.User.Enums.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String address;

    @NotNull
    private UserType userType;
}
