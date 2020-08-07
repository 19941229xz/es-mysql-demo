package com.example.esmysqldemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(indexName = "i_vue_admin")
public class Order implements Serializable {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String orderName;

    @Field(type = FieldType.Date,format= DateFormat.basic_date)
    private Date createTime;

    @Field(type = FieldType.Integer)
    private int productCount;




}
