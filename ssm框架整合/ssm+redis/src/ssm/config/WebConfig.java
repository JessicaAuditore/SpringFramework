package ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
//定义Spring MVC扫描的包
@ComponentScan(value = "ssm.*",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
//启动Spring MVC配置
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    /*
    * 通过注解@Bean初始化视图解析器
    * @return ViewResolver视图解析器
    * */
    @Bean(name = "internalResourceViewResolver")
    public ViewResolver initViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /*
    * 初始化RequestMappingHandlerAdapter，并加载Http是Json转换器
    * @return RequestMappingHandlerAdapter对象
    * */
    @Bean(name = "requestMappingHandlerAdapter")
    public HandlerAdapter initRequestMappingHandlerAdapter(){
        //创建RequestMappingHandlerAdapter适配器
        RequestMappingHandlerAdapter adapter=new RequestMappingHandlerAdapter();
        //HTTP JSON转换器
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter=new MappingJackson2HttpMessageConverter();
        //MappingJackson2HttpMessageConverter接受JSON类型消息的转换
        MediaType mediaType=MediaType.APPLICATION_JSON_UTF8;
        List<MediaType> mediaTypes=new ArrayList<MediaType>();
        mediaTypes.add(mediaType);
        //加入转换器的支持类型
        jackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        //往适配器加入json转换器
        adapter.getMessageConverters().add(jackson2HttpMessageConverter);
        return adapter;
    }
}
