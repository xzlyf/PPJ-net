package com.xz.ppjnet;

import com.xz.ppjnet.service.DocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PpjNetApplicationTests {

    @Autowired
    private DocService docService;

    @Test
    void contextLoads() {
        //String regex = "^\\d*、";
        //String path = "C:\\Users\\CZR20\\Desktop\\ACP云计算-单选题.docx";
        //List<String> strings = docService.readDoc(path);
        //String[] split = strings.get(0).split("参考答案：");
        //for (int i = 0; i < split.length; i++) {
        //    System.out.println("题目：\n" + split[i]);
        //    System.out.println("答案：" + split[i + 1]);
        //    i += 1;
        //}
    }

}
