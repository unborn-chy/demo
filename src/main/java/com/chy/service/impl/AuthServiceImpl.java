package com.chy.service.impl;

import com.chy.bo.UserInfo;
import com.chy.bo.UserToken;
import com.chy.constant.JwtConstant;
import com.chy.dto.LoginDto;
import com.chy.enums.UserErrorEnum;
import com.chy.exception.BizException;
import com.chy.service.AuthService;
import com.chy.utils.JwtUtils;
import org.springframework.stereotype.Service;

/**
 * @author chy
 * @since 2021-08-24 21:54
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public UserToken login(LoginDto loginDto) {
        // 不等于 chy -  12345
        if (!("chy".equals(loginDto.getUsername()) && "12345".equals(loginDto.getPassword()))) {
            throw new BizException(UserErrorEnum.VALIDATE_USER_NAME_PASSWORD_ERROR);
        }
        // 登录成功 生成两个token
        return generateToken();
    }

    private UserToken generateToken() {
        UserInfo userInfo = new UserInfo(1, "chy");

        String accessToken = JwtUtils.sign(userInfo, JwtConstant.EXPIRE_TIME_ONE_DAY);
        String refreshToken = JwtUtils.sign(userInfo, JwtConstant.EXPIRE_TIME_FIFTEEN_DAY);
        return new UserToken(accessToken, refreshToken);
    }

    /**
     * 每次请求携带两个token
     * 判断 accessToken 是否过期
     *    - 没过期，照原返回
     *    - 过期 判断 refreshToken 是否过期
     *          - 没过期，生成新的两个新的 token返回
     *          - 过期  重新登录
     *
     * @param accessToken
     * @param refreshToken
     * @return
     */
    @Override
    public UserToken verify(String accessToken, String refreshToken) {

        UserToken userToken = new UserToken(accessToken, refreshToken);

        UserInfo accessUserInfo = JwtUtils.verify(accessToken);
        if (accessUserInfo != null) {
            return userToken;
        }
        UserInfo refreshUserInfo = JwtUtils.verify(refreshToken);
        if (refreshUserInfo == null) {

            throw new BizException(UserErrorEnum.USER_AUTH_TIME_OUT_ERROR);
        }
        return generateToken();
    }

}