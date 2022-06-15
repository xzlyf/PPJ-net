package com.xz.ppjnet.dao;

import com.xz.ppjnet.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 19:19
 */
@Repository
public interface UserDao {
    void serUser(User user);

    int  getUserId(String user);
}
