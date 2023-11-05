package org.simple_board_willd.db.User;

import org.simple_board_willd.db.User.Enums.UserStatus;
import org.simple_board_willd.db.User.Enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from user where id = ? and user_type = ? and status = ? order by id desc limit 1
    Optional<UserEntity> findFirstByIdAndUserTypeAndStatusOrderByIdDesc(Long userId, UserType userType, UserStatus status);

    // select * from user where email = ? and password = ? order by id desc limit 1
    Optional<UserEntity> findFirstByEmailAndPasswordOrderByIdDesc(String email, String password);
}
