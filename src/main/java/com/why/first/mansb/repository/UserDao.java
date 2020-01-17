package com.why.first.mansb.repository;

import com.why.first.mansb.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserDO, Integer> {
    UserDO findByUsername(String username);
}
