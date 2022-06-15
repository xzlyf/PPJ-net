package com.xz.ppjnet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 12:12
 */
@Data
public class Tiku {
    private int id;
    private String quiz;
    private String answer;

    public Tiku() {
    }

    public Tiku(String quiz, String answer) {
        this.quiz = quiz;
        this.answer = answer;
    }
}
