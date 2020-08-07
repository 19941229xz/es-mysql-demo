package com.example.esmysqldemo.dao;

import com.example.esmysqldemo.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDao {


    @Insert("insert into `order`(id,orderName,productCount)values(#{id},#{orderName},#{productCount})")
    public int addOrder(Order order);

    @Select("select * from `order` where id=#{id}")
    public Order getOrderById(String id);


}
