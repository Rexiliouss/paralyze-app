package com.paralyze.paralyze.Repository;

import com.paralyze.paralyze.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
