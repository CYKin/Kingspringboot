package com.king.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 全局异常处理
 * @author wangchangyong
 * @create 2018/05/23 10:56
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * 处理 Exception 类型的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("msg", e.toString());
        modelAndView.addObject("url", request.getRequestURI());
        return modelAndView;
    }

    /**
     * 堆栈信息
     * @param t
     * @return
     */
    public static String printStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }
}
