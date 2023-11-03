package org.simple_board_willd.db.User;

import org.simple_board_willd.db.User.Enums.UserStatus;
import org.simple_board_willd.db.User.Enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //일반 사용자 or 어드민 사용자 조회 and 활성화된 사용자 조회
    // select * from user where id = ? and user_type = ? and status = ? order by id desc limit 1
    Optional<UserEntity> findFirstByIdAndUserTypeAndStatusOrderByIdDesc(Long userId, UserType userType, UserStatus status);

    //이메일, 패스워드를 통해서 사용자 정보 조회 and 활성, 비활성
    // select * from user where email = ? and password = ? and status order by id desc limit 1
    Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(String email, String password, UserStatus status);



}
