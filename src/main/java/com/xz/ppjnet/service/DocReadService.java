package com.xz.ppjnet.service;

import java.util.List;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:15
 */
public interface DocReadService {

    /**
     * 读取一个doc/docx文件
     * @param path
     * @return
     */
    List<String> readDoc(String path);

}
