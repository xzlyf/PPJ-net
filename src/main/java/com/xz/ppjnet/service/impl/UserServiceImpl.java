package com.xz.ppjnet.service.impl;

import com.xz.ppjnet.dao.UserDao;
import com.xz.ppjnet.entity.User;
import com.xz.ppjnet.exception.BusinessException;
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
    public User setUser(User u) {
        try {
            userDao.insertUser(u);
        } catch (Exception e) {
            //已存在，判断密码
            User remote = userDao.findUser(u);
            if (remote == null) {
                throw new BusinessException("用户名或密码错误");
            }
            u.setId(remote.getId());
        }
        //存入redis
        redisUtil.set(u.getName(), u.getId(), 3600);
        return u;
    }
}
