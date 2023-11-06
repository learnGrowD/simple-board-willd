package org.simple_board_willd.api.domain.user.controller.model;

import lombok.*;
import org.simple_board_willd.db.User.Enums.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @Email
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "패스워드를 입력해주세요.")
    private String password;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    @NotNull(message = "계정타입을 입력해주세요.")
    private UserType userType;
}
