package com.seagrey.dao;

import com.seagrey.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserNameAndPassword(String username,String password);
}
