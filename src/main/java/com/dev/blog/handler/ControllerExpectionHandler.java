package com.dev.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice //可以拦截所有的带有controller的注解
public class ControllerExpectionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //可以通过访问的HttpServletRequest来了解到访问的是哪个异常
    @ExceptionHandler(Exception.class)   //ExceptionHandler就是来表示这个方法是可以做异常处理的
    //Exception.class代表只要是拦截的是exception的都可以
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        //logger日志的打印与传输
        logger.error("Requst URL : {}, Exception : {}", request.getRequestURL(), e);

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return  mv;
    }
}
