package com.xz.ppjnet.controller;

import com.xz.module.common.exception.BusinessException;
import com.xz.ppjnet.service.DocReadService;
import com.xz.ppjnet.service.TikuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:24
 */
@RestController
@RequestMapping("/tiku")
public class TikuController {

    @Autowired
    private DocReadService docReadService;
    @Autowired
    private TikuService tikuService;

    @GetMapping("/admin")
    public int adminSet(@RequestParam String pwd){
        if (!pwd.equals("xzlyf297")){
            throw new BusinessException("你不是管理员");
        }

        String filepath = "C:\\Users\\CZR20\\Desktop\\ACP云计算-单选题.docx";
        List<String> strings = docReadService.readDoc(filepath);
        if (strings.size()==0){
            throw new BusinessException("文档读取异常");
        }
        String[] split = strings.get(0).split("参考答案：");
        tikuService.addTi(split);

        return split.length;
    }

}
