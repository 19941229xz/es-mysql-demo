package com.example.esmysqldemo.mq;

import com.example.esmysqldemo.Service.OrderEsService;
import com.example.esmysqldemo.Service.OrderMybatisService;
import com.example.esmysqldemo.Service.OrderMybatisServiceImpl;
import com.example.esmysqldemo.model.Order;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderOptListener {

    @Autowired
    OrderEsService orderEsService;

    @Autowired
    OrderMybatisServiceImpl orderMybatisService;


    @RabbitListener(queuesToDeclare = @Queue("es.mysql.copy.data"))
    public void copyDataToEsFromMysql(String msg){
        //解析消息
        String[] strings = msg.split("-");
        //获取订单ID
        String orderId = strings[0];
        //获取操作类型
        String type = strings[1];

        if(type.equals("insert")){
            // 在es业务类中 没有update这个方法
            // 它将 add 和 update 合并了 save
            //取决于你的实体类中 有不有主键
            //从数据据库中  通过ID获取 订单完整数据（后期可以用redis优化）
            Order order = orderMybatisService.getOrderById(orderId);
            orderEsService.save(order);
        }

    }




}
