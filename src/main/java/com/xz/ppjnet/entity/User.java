package com.xz.ppjnet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 19:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private String passwd;
    private Date createTime;
}
