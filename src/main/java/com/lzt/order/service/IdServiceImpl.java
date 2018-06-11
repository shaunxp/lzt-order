package com.lzt.order.service;

import com.lzt.order.dao.OrderDao;
import com.lzt.order.domain.Order;
import com.lzt.order.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IdServiceImpl implements IdService {

    private static final Logger logger = LoggerFactory.getLogger(IdServiceImpl.class);

    @Resource
    OrderDao orderDao;

    @Override
    public void getId() {
        try {
            IdWorker idWorker = new IdWorker(0, 0);
            long id = idWorker.nextId();
            Order order = new Order(String.valueOf(id));
            int result = orderDao.insert(order);
            logger.info("insert result :{}", result);
        } catch (Exception e) {
            logger.error("get id error:{}", e);
        }


    }
}
