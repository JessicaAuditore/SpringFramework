package com.example.springbootdatajpa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

//使用jpa注解配置映射关系
@Entity //告诉jpa这是一个实体类（和数据表映射的类）
@Table(name = "t_user") //@Table来指定和哪个数据表对应，如果省略默认表名就是user
@ApiModel(value = "用户模型")
@Data
public class User {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    @ApiModelProperty("用户id")
    private Integer id;
    @Column(name = "last_name",length = 50)
    @ApiModelProperty("用户姓名")
    private String lastName;
    @Column //省略默认名就是属性名
    @ApiModelProperty("用户邮箱")
    private String email;
}
