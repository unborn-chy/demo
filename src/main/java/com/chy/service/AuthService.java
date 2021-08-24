package com.chy.service;

import com.chy.bo.UserToken;
import com.chy.dto.LoginDto;

/**
 * @author chy
 * @since 2021-08-24 21:49
 */
public interface AuthService {
    /**
     * 登录
     * @param loginDto
     * @return
     */
     UserToken login(LoginDto loginDto);

    /**
     * 刷新两个token
     * @param accessToken
     * @param refreshToken
     * @return
     */
    UserToken verify(String accessToken, String refreshToken);
}
