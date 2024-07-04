package com.jeven.Kap.s.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeven.Kap.s.Model.UserAuth;

public interface UserAuthRepository  extends JpaRepository<UserAuth, Long>{
    Optional<UserAuth> findByEmail( String email);
    Optional<UserAuth> findByUsername(String username);
    Optional<UserAuth> findByUsernameorEmail(String Email, String username);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
