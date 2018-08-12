package com.example.springbootwebrestfulcrud.config;

import com.example.springbootwebrestfulcrud.filter.MyFilter;
import com.example.springbootwebrestfulcrud.listener.MyListener;
import com.example.springbootwebrestfulcrud.serlvet.MyServlet;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件 serlvet filter listener
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean=new ServletListenerRegistrationBean<MyListener>(new MyListener());
        return registrationBean;
    }



    //嵌入式的Servlet容器的定制器
//    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer() {
            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(WebServerFactory factory) {
                ((TomcatServletWebServerFactory) factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
                    @Override
                    public void customize(Connector connector) {
                        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                        protocol.setPort(8083);
                    }
                });
            }
        };
    }
}
