package com.chy.demo.dao;

import com.chy.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chy
 * @since 2021-02-22 16:21
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 根据 username ，password查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username,String password);
}
