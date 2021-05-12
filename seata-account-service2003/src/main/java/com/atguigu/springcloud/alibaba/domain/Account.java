package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2021-03-05 19:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;



}
