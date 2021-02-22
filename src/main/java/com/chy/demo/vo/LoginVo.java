package com.chy.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chy
 * @since 2021-02-22 17:57
 */
@Data
public class LoginVo {
    @NotBlank(message = "用户名不能为空")
    private String username;
    private String password;
}
