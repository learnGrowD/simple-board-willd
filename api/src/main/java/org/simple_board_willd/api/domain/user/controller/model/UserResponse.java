package org.simple_board_willd.api.domain.user.controller.model;

import lombok.*;
import org.simple_board_willd.db.User.Enums.UserStatus;
import org.simple_board_willd.db.User.Enums.UserType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;

    private String name;

    private String email;

    private String address;

    private UserStatus status;

    private UserType userType;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime lastLoginAt;
}
