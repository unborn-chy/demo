package com.chy.controller;

import com.chy.bo.UserToken;
import com.chy.dto.LoginDto;
import com.chy.service.AuthService;
import com.chy.to.Result;
import com.chy.valid.Add;
import com.chy.valid.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chy
 * @since 2021-08-24 21:43
 */
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/auth/login")
    public Result<UserToken>login(@RequestBody @Validated LoginDto loginDto) {
          return Result.success(authService.login(loginDto));
    }

    @PostMapping("/auth/verify")
    public Result<UserToken>verify(@RequestHeader("accessToken") String accessToken,
                                   @RequestHeader("refreshToken") String refreshToken) {
          return Result.success(authService.verify(accessToken,refreshToken));
    }
}
