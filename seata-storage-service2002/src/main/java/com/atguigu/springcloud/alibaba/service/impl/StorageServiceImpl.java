package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2021-03-05 19:23
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService{

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, int count) {
        log.info("-----开始扣减库存");
        storageDao.decrease(productId,count);
        log.info("------完成扣减库存");
    }
}
