package ssm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //DispatcherServlet拦截请求配置
    @Override
    protected String[] getServletMappings() {
        return new String[]{".action"};
    }

    //Spring IoC环境变量
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //配置Spring IoC
        return new Class<?>[]{RootConfig.class};
    }

    //DispatcherServlet环境配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }
}
