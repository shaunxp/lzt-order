package com.lzt.order.dao;

import com.lzt.order.domain.Order;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Resource
    private SqlSession sst;

    private final String namespace = "com.lzt.order.dao.OrderDao.";


    @Override
    public int insert(Order order) {
        return sst.insert(namespace + "insert", order);
    }
}
