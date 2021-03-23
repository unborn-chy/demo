package com.chy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.dto.UserDTO;
import com.chy.entity.User;
import com.chy.to.PageQueryTO;

import java.util.List;

/**
 * @author chy
 * @since 2021-03-21 21:14
 */
public interface UserService {
    List<User> getAll();

    void save(UserDTO userDTO);

    void update(UserDTO userDTO);

    /**
     * 批量添加用户
     */
    void batchSaveUser();


     Page<User> listUser(PageQueryTO pageQueryTO);
}
