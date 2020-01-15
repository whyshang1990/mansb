package com.why.first.mansb.repository;

import com.why.first.mansb.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserDO, Integer> {
    UserDO findByName(String name);
}
