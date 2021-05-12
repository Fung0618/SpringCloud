package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2021-03-05 19:47
 */
@Mapper
public interface AccountDao {

    public void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);

}
