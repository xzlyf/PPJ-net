package com.xz.ppjnet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xz.ppjnet.entity.Tiku;
import org.springframework.stereotype.Repository;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 12:05
 */
@Repository
public interface TikuDao extends BaseMapper<Tiku> {
    //todo  批量存入数据库
    //todo mysql驱动连接不上
}
