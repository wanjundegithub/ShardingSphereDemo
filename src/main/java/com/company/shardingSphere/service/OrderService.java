package com.company.shardingSphere.service;

import com.company.shardingSphere.mapper.OrderMapper;
import com.company.shardingSphere.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public void saveOrder(Order order){
        orderMapper.insertOrder(order);
    }

    public List<Order> selectOrderByUserID(Long userId){
        return orderMapper.selectOrdersByUserId(userId);
    }

    public List<Order> selectAll(){
        return orderMapper.selectAll();
    }
}
