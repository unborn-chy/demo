package com.chy.demo.service.impl;


import com.chy.demo.dao.UserRepository;
import com.chy.demo.entity.User;
import com.chy.demo.enums.UserEnum;
import com.chy.demo.exception.GlobalException;
import com.chy.demo.service.UserService;
import com.chy.demo.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author chy
 * @since 2021-02-21 17:05
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    //根据用户名密码查询用户

    @Override
    public User login(LoginVo login) {
        User dbUser = userRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if (dbUser == null) {
            throw new GlobalException(UserEnum.USER_IS_NULL);
        }
        return dbUser;
    }
}
