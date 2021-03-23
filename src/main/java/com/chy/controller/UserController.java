package com.chy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.dto.UserDTO;
import com.chy.entity.User;
import com.chy.service.UserService;
import com.chy.to.PageQueryTO;
import com.chy.utils.PageResult;
import com.chy.utils.Result;
import com.chy.valid.Add;
import com.chy.valid.Update;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chy
 * @since 2021-03-21 21:16
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("/getAll")
    public Result<List<User>> getAll(){
        return Result.success(userService.getAll());
    }

    /**
     * 添加用户
     */
    @PostMapping("/addUser")
    public Result<String> addUser(@Validated(Add.class) @RequestBody UserDTO userDTO){
        log.error("userDto:{}",userDTO);
        userService.save(userDTO);
        return Result.success();

    }
    /**
     * 修改用户
     */
    @PostMapping("/updateUser")
    public Result<String> updateUser(@Validated(Update.class) @RequestBody UserDTO userDTO){
        log.error("userDto:{}",userDTO);
        userService.update(userDTO);
        return Result.success();
    }

    /**
     * 插入10000条用户信息
     * @return
     */
    @GetMapping("/batchSaveUser")
    public Result<String> batchSaveUser(){
        userService.batchSaveUser();
        return Result.success();
    }

    /**
     * 分页查询用户
     * @return
     */

    @GetMapping("/listUser")
    public PageResult<User> listUser(PageQueryTO pageQueryTO){

        log.error("pageQueryTO:{}",pageQueryTO);
        Page<User> page = userService.listUser(pageQueryTO);
        return PageResult.success(page);
    }


}
