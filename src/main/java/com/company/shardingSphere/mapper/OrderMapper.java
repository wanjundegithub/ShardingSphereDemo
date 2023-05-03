package com.company.shardingSphere.mapper;

import com.company.shardingSphere.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    void insertOrder(Order order);

    List<Order> selectOrdersByUserId(@Param("userId") Long userId);
}
