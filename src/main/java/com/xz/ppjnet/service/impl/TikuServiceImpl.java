package com.xz.ppjnet.service.impl;

import com.xz.ppjnet.dao.TikuDao;
import com.xz.ppjnet.entity.Tiku;
import com.xz.ppjnet.service.TikuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:52
 */
@Service
public class TikuServiceImpl implements TikuService {
    @Autowired
    private TikuDao tikuDao;

    @Override
    public void addTi(String[] tiData) {
        for (int i = 0; i < tiData.length; i++) {
            //System.out.println("题目：\n" + tiData[i]);
            //System.out.println("答案：" + tiData[i + 1]);
            tikuDao.insert(new Tiku(tiData[i], tiData[i + 1]));
            i += 1;
        }
    }
}
