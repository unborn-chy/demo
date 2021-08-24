package com.chy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.dto.UserDto;
import com.chy.pojo.User;
import com.chy.to.PageQueryTo;

import java.util.List;

/**
 * @author chy
 * @since 2021-03-21 21:14
 */
public interface UserService {
    List<User> getAll();

    void save(UserDto userDTO);

    void update(UserDto userDTO);

    /**
     * 批量添加用户
     */
    void batchSaveUser();


     Page<User> listUser(PageQueryTo pageQueryTO);
}
