package com.xz.ppjnet.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xz.ppjnet.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/6 18:34
 */
@Controller
@RequestMapping("/")
public class IndexController {
    public static final String BILI_MOVIE_INFO = "http://api.bilibili.com/x/web-interface/view?bvid=";
    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("/checkBV")
    public Object checkBV(@RequestParam String bv) {
        ResponseEntity<String> responseEntity;
        //通过bili api获取视频信息
        responseEntity = restTemplate.getForEntity(BILI_MOVIE_INFO + bv, String.class);
        String body = responseEntity.getBody();
        JSONObject obj = JSON.parseObject(body);
        if (obj == null || obj.getInteger("code") != 0) {
            throw new BusinessException();
        }
        return obj.get("data");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
