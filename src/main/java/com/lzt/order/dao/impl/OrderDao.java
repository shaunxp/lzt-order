package com.lzt.order.dao.impl;

import com.lzt.order.dao.IOrderDao;
import com.lzt.order.domain.Order;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrderDao implements IOrderDao{

    @Resource
    private SqlSession sst;

    private final String namespace = "com.lzt.order.dao.IOrderDao.";

    @Override
    public int insert(Order order) {
        return sst.insert(namespace + "insert", order);
    }
}
