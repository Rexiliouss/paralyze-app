package com.paralyze.paralyze.Repository;

import com.paralyze.paralyze.Model.ParalyzeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParalyzeUserRepository extends JpaRepository<ParalyzeUser,Long> {
}
