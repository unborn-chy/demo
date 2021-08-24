package com.chy.bo;

/**
 * @author chy
 * @since 2021-08-24 21:26
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JWT相关 用户id, name
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer Id;
    private String  name;
}
