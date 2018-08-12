package com.example.springbootcache.config;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
//给包下的所有接口添加@Mapper注解
@MapperScan(value = "com.example.springbootcache.mapper")
public class MyBatisConfig {

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory intiSqlSessionFactory(DataSource druid) throws Exception {
        SqlSessionFactoryBean fb=new SqlSessionFactoryBean();
        fb.setDataSource(druid);
        fb.setTypeAliasesPackage("com.example.springbootcache.entity");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));
        Configuration configuration=new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        fb.setConfiguration(configuration);
        return fb.getObject();
    }
}
