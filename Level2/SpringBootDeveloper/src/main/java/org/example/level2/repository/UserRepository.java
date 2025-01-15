package org.example.level2.repository;


import org.example.level2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // 1 email로 사용자 정보를 가져옴
    // 실제 실행하는 쿼리
    // FROM users
    // WHERE email = #{email}
}
