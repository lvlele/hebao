package com.hebao.hbservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 薏生科技 on 2017/10/11.
 */
// 自动生成get set方法
@Data
// build方法
@Builder
// 无参构造方法
@NoArgsConstructor
// 全参构造方法
@AllArgsConstructor
public class People {
    private int id;
    private String name;
    private int age;
}
