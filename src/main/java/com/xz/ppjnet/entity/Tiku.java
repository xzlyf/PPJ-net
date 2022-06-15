package com.xz.ppjnet.entity;

import lombok.Data;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 12:12
 */
@Data
public class Tiku {
    private int id;
    private String question;
    private String answer;

    private int typeId;

    public Tiku() {
    }

    public Tiku(String question, String answer, int typeId) {
        this.question = question;
        this.answer = answer;
    }
}
