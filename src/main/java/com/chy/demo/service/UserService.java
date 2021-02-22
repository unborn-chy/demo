package com.chy.demo.service;


import com.chy.demo.entity.User;
import com.chy.demo.vo.LoginVo;

public interface UserService {
    User login(LoginVo login);
}
