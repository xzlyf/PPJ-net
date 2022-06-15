package com.xz.ppjnet.controller;

import com.xz.module.common.exception.BusinessException;
import com.xz.ppjnet.service.DocService;
import com.xz.ppjnet.service.TikuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:24
 */
@RestController
@RequestMapping("/tiku")
public class TikuController {

    @Autowired
    private TikuService tikuService;

    @GetMapping("/admin")
    public void adminSet(@RequestParam String pwd) {
        if (!pwd.equals("xzlyf297")) {
            throw new BusinessException("你不是管理员");
        }

        String filepath = "C:\\Users\\CZR20\\Desktop\\ACP云计算-单选题.docx";
        String filepath2 = "C:\\Users\\CZR20\\Desktop\\ACP云计算-多选题-.docx";
//        tikuService.readTemplateA(filepath);
//        tikuService.readTemplateB(filepath2);
    }

    /**
     * 随机取出一道题
     *
     * @param type 题库类型
     */
    @GetMapping("/getOne")
    public Object getOne(@RequestParam int type) {
        return null;
    }

}
