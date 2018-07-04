package com.lzt.order.service.impl;

import com.lzt.order.dao.IOrderDao;
import com.lzt.order.domain.Order;
import com.lzt.order.service.IOrderServie;
import com.lzt.order.util.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements IOrderServie {

    @Resource
    IOrderDao orderDao;

    @Resource
    SnowflakeIdWorker idWorker;

    @Override
    public int saveOrder() {
        Order order = new Order();
        long id = idWorker.nextId();
        order.setOrderId(String.valueOf(id));
        return orderDao.insert(order);
    }
}
