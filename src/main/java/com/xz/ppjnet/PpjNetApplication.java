package com.xz.ppjnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//扫描子模块，不然子模块的注解不生效
@ComponentScan({"com.xz.ppjnet", "com.xz.module.common"})
public class PpjNetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpjNetApplication.class, args);
    }
}
