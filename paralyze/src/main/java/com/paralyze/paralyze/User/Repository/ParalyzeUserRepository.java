package com.paralyze.paralyze.User.Repository;

import com.paralyze.paralyze.User.Model.ParalyzeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParalyzeUserRepository extends JpaRepository<ParalyzeUser,Long> {
    Optional<ParalyzeUser> findByEmail(String email);
}
