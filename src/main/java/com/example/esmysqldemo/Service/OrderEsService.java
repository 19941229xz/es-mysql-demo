package com.example.esmysqldemo.Service;


import com.example.esmysqldemo.model.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

//如果你想让 OrderEsService 具备操作es的功能 需要继承
// ElasticsearchRepository<实体类的类型，实体类主键的类型>
// 继承以后 OrderEsService 就具备了crud 包括复杂查询
//不需要创建实现类
@Service
public interface OrderEsService extends ElasticsearchRepository<Order,String> {
}
