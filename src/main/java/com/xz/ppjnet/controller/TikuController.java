package com.xz.ppjnet.controller;

import com.xz.ppjnet.entity.User;
import com.xz.ppjnet.exception.BusinessException;
import com.xz.ppjnet.service.TikuService;
import com.xz.ppjnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:24
 */
@Controller
@RequestMapping("/tiku")
public class TikuController {

    @Autowired
    private TikuService tikuService;
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    @ResponseBody
    public void adminSet(@RequestParam String pwd) {
        if (!pwd.equals("xzlyf297")) {
            throw new BusinessException("你不是管理员");
        }

        String filepath = "C:\\Users\\CZR20\\Desktop\\ACP云计算-单选题.docx";
        String filepath2 = "C:\\Users\\CZR20\\Desktop\\ACP云计算-多选题-.docx";
//        tikuService.readTemplateA(filepath);
//        tikuService.readTemplateB(filepath2);
    }

    @GetMapping("/index")
    public String index() {
        return "index-m";
    }
    @GetMapping("/shuati")
    public String shuati() {
        return "shuati-m";
    }

    /**
     * 设置用户名
     *
     * @param user length<16
     */
    @PostMapping("/setUser")
    @ResponseBody
    public Object setUser(@RequestBody User user) {
        if (user.getName() == null || user.getPasswd() == null) {
            throw new BusinessException("参数错误");
        }
        if (user.getName().length() < 4 || user.getPasswd().length() < 4) {
            throw new BusinessException("参数不符合规范");
        }
        return userService.setUser(user);
    }

    /**
     * 随机取出一道题
     *
     * @param type 题库类型
     */
    @GetMapping("/getOne")
    @ResponseBody
    public Object getOne(@RequestParam int type,
                         @RequestParam String user) {
        return tikuService.getOne(type, user);
    }

    @GetMapping("/checkOne")
    @ResponseBody
    public Object checkOne(@RequestParam String answer,
                           @RequestParam int tikuId,
                           @RequestParam String user) {
        return tikuService.checkOne(tikuId, answer, user);
    }


    @GetMapping("/getWrong")
    @ResponseBody
    public Object getWrong(@RequestParam String user){
        return tikuService.getWrong(user);
    }
}
