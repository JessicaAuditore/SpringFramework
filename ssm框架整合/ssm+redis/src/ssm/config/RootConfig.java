package ssm.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//定义Spring扫描的包
@ComponentScan(value = "ssm.*",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class})})
//使用事务驱动管理器
@EnableTransactionManagement
//实现接口TransactionManagementConfigurer，这样可以配置注解驱动事务
public class RootConfig implements TransactionManagementConfigurer {

    private DataSource dataSource = null;

    /*
     * 配置数据库
     *
     * @return 数据连接池dbcp
     * */
    @Bean(name = "dataSource")
    public DataSource initDataSource() {
        if (dataSource != null) {
            return dataSource;
        }
        Properties props = new Properties();
        props.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql:///ssmwithredis?serverTimezone=GMT&useUnicode=true&characterEncoding=UTF8");
        props.setProperty("username", "root");
        props.setProperty("password", "xiaokaixian");
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    /**
     * 配置SqlSessionFactory
     *
     * @return SqlSessionFactory
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean initSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(initDataSource());
        //配置MyBatis配置文件
        Resource resource = new ClassPathResource("ssm/config/mybatis/mybatis-config.xml");
        sqlSessionFactory.setConfigLocation(resource);
        return sqlSessionFactory;
    }

    /*
     * 通过自动扫描，发现MyBatis Mapper接口
     *
     * @return Mapper扫描器
     * */
    @Bean
    public MapperScannerConfigurer initMapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //扫描包
        msc.setBasePackage("ssm.*");
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //区分注解扫描
        msc.setAnnotationClass(Repository.class);
        return msc;
    }

    /*
     * 实现接口方法，注册注解事务，当@Transactional使用的时候产生数据库事务
     * */
    @Override
    @Bean(name = "annotationDrivenTransactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(initDataSource());
        return transactionManager;
    }
}
