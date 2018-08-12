package cn.itcast.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//全局异常处理器
public class CustomExceptionResolver implements HandlerExceptionResolver {

    //e就是系统抛出的异常
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //handler就是处理器适配器要执行的Handler对象（只有method）
        //解析出异常类型
//        String message = null;
//        if (e instanceof CustomException) {
//            //如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
//            message = ((CustomException) e).getMessage();
//        } else {
//            //如果该异常类型不是系统自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
//            message = "未知错误";
//        }

        //上边代码变为
        CustomException customException = null;
        if (e instanceof CustomException) {
            customException = (CustomException) e;
        } else {
            customException = new CustomException("未知错误");
        }
        //错误信息
        String message = customException.getMessage();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
