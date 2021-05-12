package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2021-02-25 14:34
 */
@Data //自动补属性get set标签
@AllArgsConstructor //自动补全entity类的全参构造标签
@NoArgsConstructor  //自动补全entity类属性的空参构造标签
public class Payment implements Serializable{

    private Long id;
    private String serial;

}
