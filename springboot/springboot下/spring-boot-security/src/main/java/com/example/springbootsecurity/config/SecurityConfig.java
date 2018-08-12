package com.example.springbootsecurity.config;

import com.example.springbootsecurity.util.MyPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能 效果，如果登录没有权限就来到登录界面
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");
        //1、/login请求来到登录页
        //2、重定向/login?error表示登录失败
        //3、更多详细规定
        //4、默认post形式的/login代表处理系统
        //5、一旦定制loginPage:那么loginPage的post请求就是登录

        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/");
        //1、访问/logout 表示用户注销，清空session
        //2、注销成功会返回 /login?logout页面

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
        //登录成功以后，将cookie发给浏览器，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("zhangsan").password("123").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123").roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password("123").roles("VIP1", "VIP3");
    }
}
