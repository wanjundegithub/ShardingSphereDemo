package com.company.shardingSphere;

import com.company.shardingSphere.model.Order;
import com.company.shardingSphere.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserMapperTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testInsert(){
        for(int i=0;i<10;i++){
            Order order = new Order();
            order.setId((long)i);
            order.setUserId((long)i);
            order.setOrderId((long)i);
            order.setCloumn("column"+i);
            orderService.saveOrder(order);
        }
    }
}
