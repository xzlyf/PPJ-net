package com.xz.ppjnet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xz.ppjnet.entity.Tiku;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 12:05
 */
@Repository
public interface TikuDao extends BaseMapper<Tiku> {
    List<Tiku> getRandom(int typeId, int userId);

    String getAnswer(int id);

    void addFilter(int tikuId,int userId,int tag);

    List<Tiku> getWrong(int userId);

    int updateTag(int userId,int tikuId);
}