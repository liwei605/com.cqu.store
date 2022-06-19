package com.cqu.store.mapper;


import com.cqu.store.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;


    @Test
    public void findHotList() {
        List<Product> list = productMapper.findHotList();
        System.err.println("count=" + list.size());
        for (Product item : list) {
            System.err.println(item);
        }
    }

}
