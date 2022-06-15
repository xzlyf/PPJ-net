package com.xz.ppjnet.service.impl;

import com.xz.ppjnet.dao.UserDao;
import com.xz.ppjnet.entity.User;
import com.xz.ppjnet.service.UserService;
import com.xz.ppjnet.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 19:19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User setUser(String name) {
        User u = new User(0, name);
        try {
            userDao.serUser(u);
        } catch (Exception e) {
            //已存在，查询id
            int id = userDao.getUserId(name);
            u.setId(id);
        }
        //存入redis
        redisUtil.set(name, u.getId(),3600);
        return u;
    }
}
