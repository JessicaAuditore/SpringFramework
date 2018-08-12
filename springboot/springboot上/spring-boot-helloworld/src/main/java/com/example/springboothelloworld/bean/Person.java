package com.example.springboothelloworld.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
* 将配置文件中配置的每一个属性的值，映射到这个组建中
* @ConfigurationProperties：告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定
* prefix = "person" 配置文件中哪个下面的所有属性进行一一映射
* 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties
* */
//@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

    /*
    * <bean class="Person">
    *       <property name="lastName" value="字面量/${key}从环境变量，配置文件中获取值/#{SpEL}"></property>
    * </bean>
    * */
//    @Value("${person.lastname}")
//    @Email//lastName必须是邮箱格式 要使用必须用@ConfigurationProperties和@Validated
    private String lastName;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;
//    @Value("${person.map}") 不支持！
    private Map<String, Object> map;
    private List<Object> list;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
