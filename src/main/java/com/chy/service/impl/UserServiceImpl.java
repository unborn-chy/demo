package com.chy.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.dto.UserDto;
import com.chy.pojo.User;
import com.chy.enums.UserTypeEnum;
import com.chy.mapper.UserMapper;
import com.chy.service.UserService;
import com.chy.to.PageQueryTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chy
 * @since 2021-03-21 21:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.selectList(null);
    }

    /**
     * 添加用户
     *
     * @param userDTO
     */
    @Override
    public void save(UserDto userDTO) {
        User user = new User();
        // 判断用户类型是否合法
        UserTypeEnum.getUserTypeEnumByCode(userDTO.getUserType());
        BeanUtils.copyProperties(userDTO, user);
        userMapper.insert(user);
    }

    @Override
    public void update(UserDto userDTO) {
        User user = new User();
        // 判断用户类型是否合法
        UserTypeEnum.getUserTypeEnumByCode(userDTO.getUserType());
        BeanUtils.copyProperties(userDTO, user);

        userMapper.updateById(user);
    }

    /**
     * 分页数据
     */
    @Override
    public void batchSaveUser() {

        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setAge(i % 100);
            user.setName("张三" + i);
            user.setUserType(UserTypeEnum.READER.getCode());
            userMapper.insert(user);
        }
    }

    @Override
    public Page<User> listUser(PageQueryTo pageQueryTO) {
        Page<User> page = new Page<>();
        page.setCurrent(pageQueryTO.getPage());
        page.setSize(pageQueryTO.getPageSize());
//        Wrapper<User> queryWrapper   = new QueryWrapper<>();
        Page<User> page1 = userMapper.selectPage(page, null);
        return page1;
    }
}
