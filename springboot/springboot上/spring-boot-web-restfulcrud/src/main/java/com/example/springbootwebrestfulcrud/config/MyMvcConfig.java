package com.example.springbootwebrestfulcrud.config;

import com.example.springbootwebrestfulcrud.component.LoginHandlerInterceptor;
import com.example.springbootwebrestfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//全面接管springmvc，自动配置全部失效
//@EnableWebMvc
//使用WebMvcConfigurerAdapter可以扩展springmvc的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送/atguigu请求 来到success页面
        registry.addViewController("/atguigu").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcAutoConfigurationAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/","/user/login");
//            }
        };
        return adapter;
    }

    //国际化
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
