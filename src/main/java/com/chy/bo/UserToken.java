package com.chy.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 两个token
 * @author chy
 * @since 2021-08-24 21:51
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserToken {
    /**
     * 主要token
     */
    private String accessToken;
    /**
     * 刷新 accessToken
     */
    private String refreshToken;

}
