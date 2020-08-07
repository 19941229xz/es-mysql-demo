package com.example.esmysqldemo;

import com.example.esmysqldemo.Service.OrderEsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsMysqlDemoApplicationTests {

    @Autowired
    OrderEsService orderEsService;

    @Test
    void contextLoads() {


    }

}
