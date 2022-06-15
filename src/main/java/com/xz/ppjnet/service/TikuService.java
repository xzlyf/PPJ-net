package com.xz.ppjnet.service;

import com.xz.ppjnet.entity.Tiku;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:51
 */
public interface TikuService {
    void readTemplateA(String filepath);
    void readTemplateB(String filepath);

    void addTi(Tiku tiku);

    Tiku getOne(int typeId);
}
