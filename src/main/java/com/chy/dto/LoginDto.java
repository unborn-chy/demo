package com.chy.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录账号密码
 * @author chy
 * @since 2021-08-24 21:29
 */
@Data
public class LoginDto {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
