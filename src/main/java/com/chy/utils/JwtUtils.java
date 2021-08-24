package com.chy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chy.bo.UserInfo;
import com.chy.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author chy
 * @since 2021-08-24 21:31
 */

@Slf4j
public class JwtUtils {
    /**
     * token 私钥
     */
    private static final String TOKEN_SECRET = "07d319d1860c463e8a18b723d35902fc";

    /**
     * 加密算法
     */
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(TOKEN_SECRET);


    /**
     * 生成token15分钟后过期
     */
    public static String sign(UserInfo userInfo, long expireTime) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + expireTime);
        //生成token  默认header是有数据的 {type:JWT,alg:HS256}
        return JWT.create()
                .withClaim("id", userInfo.getId())
                .withClaim("username", userInfo.getName())
                .withExpiresAt(date)
                .sign(ALGORITHM);
    }

    /**
     * 校验token是否正确
     * 正确就返回用户信息
     */
    public static UserInfo verify(String token) {
        try {
            JWT.require(ALGORITHM).build().verify(token);
        } catch (JWTVerificationException e) {

            log.info("【token校验失败】：{}",e);
            return null;
        }

        return new UserInfo(getTokenClaimId(token),getTokenClaimUsername(token));
    }


    public static Integer getTokenClaimId(String token) {
        return JWT.decode(token).getClaim("id").asInt();
    }

    public static String getTokenClaimUsername(String token) {
        return JWT.decode(token).getClaim("username").asString();
    }
}