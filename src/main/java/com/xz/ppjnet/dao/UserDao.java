package com.xz.ppjnet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xz.ppjnet.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 19:19
 */
@Repository
public interface UserDao extends BaseMapper<User> {
    void insertUser(User user);

    User findUser(User user);
}
