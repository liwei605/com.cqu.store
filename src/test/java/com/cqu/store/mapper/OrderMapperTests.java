package com.cqu.store.mapper;
import com.cqu.store.mapper.OrderMapper;
import com.cqu.store.entity.Order;
import com.cqu.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTests {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder() {
        Order order = new Order();
        order.setUid(31);
        order.setRecvName("收货人1");
        Integer rows = orderMapper.insertOrder(order);
        System.out.println("rows=" + rows);
    }
    @Test
    public void insertOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(2);
        orderItem.setTitle("高档本子");
        Integer rows = orderMapper.insertOrderItem(orderItem);
        System.out.println("rows=" + rows);
    }
    @Test
    public void findOrderByuid() {
        Order order= orderMapper.findOrderByuid(10);
        System.err.println(order);
    }


    @Test
    public void findOrderItemByoid() {
        Order order= orderMapper.findOrderByuid(10);
        Integer oid= order.getOid();
       List<OrderItem>list= orderMapper.findOrderItemByoid(oid);
        System.err.println(list);
    }
}