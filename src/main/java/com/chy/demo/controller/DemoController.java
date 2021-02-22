package com.chy.demo.controller;

import com.chy.demo.entity.User;
import com.chy.demo.enums.CommonEnum;
import com.chy.demo.service.UserService;
import com.chy.demo.utils.BaseResult;
import com.chy.demo.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author chy
 * @since 2021-02-22 16:19
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "hello world222444555";
    }

    /**
     * 测试登录
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    public BaseResult login(@RequestBody @Valid LoginVo loginVo) {
        log.info("loginVo: {}", loginVo);
        User login = userService.login(loginVo);
        return BaseResult.success(CommonEnum.SUCCESS, login);
    }
}
