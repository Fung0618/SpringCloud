package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shkstart
 * @create 2021-03-05 19:16
 */
@Mapper
public interface StorageDao {

    public void decrease(@Param("productId") Long productId,@Param("count") Integer count);

}
