package com.xz.ppjnet.service.impl;

import com.xz.ppjnet.dao.TikuDao;
import com.xz.ppjnet.entity.Tiku;
import com.xz.ppjnet.exception.BusinessException;
import com.xz.ppjnet.service.DocService;
import com.xz.ppjnet.service.TikuService;
import com.xz.ppjnet.utils.ConvertUtil;
import com.xz.ppjnet.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:52
 */
@Service
public class TikuServiceImpl implements TikuService {
    @Autowired
    private TikuDao tikuDao;
    @Autowired
    private DocService docService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Transactional
    public void readTemplateA(String filepath) {
        List<String> strings = docService.readDoc(filepath);
        if (strings.size() == 0) {
            throw new BusinessException("文档读取异常");
        }
        //提取问题
        String[] question = strings.get(0).split("参考答案：[A-Z]");

        //提取答案
        Matcher m1 = Pattern.compile("参考答案：[A-Z]").matcher(strings.get(0));
        String[] answer = new String[question.length];
        int j = 0;
        while (m1.find()) {
            //["参考答案","A"]
            answer[j] = m1.group().split("：")[1];
            j++;
        }

        //写入数据库
        Tiku tiku = new Tiku();
        for (int i = 0; i < question.length; i++) {
            tiku.setQuestion(question[i].trim());
            tiku.setAnswer(answer[i]);
            tiku.setTypeId(1);
            addTi(tiku);
        }
    }

    @Override
    public void readTemplateB(String filepath) {
        List<String> strings = docService.readDoc(filepath);
        if (strings.size() == 0) {
            throw new BusinessException("文档读取异常");
        }
        //提取问题
        String[] question = strings.get(0).split("参考答案：([A-Z],)*[A-Z]");

        System.out.println(Arrays.toString(question));
        //todo 现在问题是 多选多了个试题解析

        //提取答案
//        Matcher m1 = Pattern.compile("参考答案：([A-Z],)*[A-Z]").matcher(strings.get(0));
//        String[] answer = new String[question.length];
//        int j = 0;
//        while (m1.find()) {
//            //["参考答案","A"]
//            answer[j] = m1.group().split("：")[1];
//            j++;
//        }
//
//        System.out.println(question.length);
//        System.out.println(answer.length);
//        //写入数据库
//        Tiku tiku = new Tiku();
//        for (int i = 0; i < question.length; i++) {
//            tiku.setQuestion(question[i].trim());
//            tiku.setAnswer(answer[i]);
//            tiku.setTypeId(2);
////            addTi(tiku);
//        }
    }


    @Override
    public void addTi(Tiku tiku) {
        tikuDao.insert(tiku);
    }

    @Override
    public Tiku getOne(int typeId, String user) {

        Integer userId = (Integer) redisUtil.get(user);
        if (userId == null) {
            throw new BusinessException("用户登录");
        }
        List<Tiku> tikus = ConvertUtil.castList(redisUtil.get(userId.toString()), Tiku.class);
        //缓存没有任务
        if (tikus == null) {
            tikus = tikuDao.getRandom(typeId, userId);
        }

        //取出一个任务
        Tiku tiku = null;
        if (tikus.size() > 0) {
            tiku = tikus.remove(0);
            redisUtil.set(userId.toString(), tikus, 300);
        }

        //如果等于tasks等于0直接删除redis
        if (tikus.size() == 0) {
            redisUtil.del(userId.toString());
        }
        return tiku;
    }

    @Override
    public boolean checkOne(int tikuId, String answer, String user) {
        Integer userId = (Integer) redisUtil.get(user);
        if (userId == null) {
            throw new BusinessException("用户未登录");
        }

        //获取正确答案
        String remote = tikuDao.getAnswer(tikuId);
        boolean b = remote.equalsIgnoreCase(answer);
        //写入过滤表
        tikuDao.addFilter(tikuId, userId, b ? 0 : 1);
        return b;
    }

    @Override
    public List<Tiku> getWrong(String user) {
        Integer userId = (Integer) redisUtil.get(user);
        if (userId == null) {
            throw new BusinessException("用户未登录");
        }
        return tikuDao.getWrong(userId);
    }

}
