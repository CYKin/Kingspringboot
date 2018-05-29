package com.king.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangchangyong
 * @create 2018/05/23 10:40
 */
@Aspect
@Component
public class TestAspect {

    private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Around("execution(* com.king.controller.FreemarkerHello..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        System.out.println("----------Aspect开始处理----------");
//        Object[] args = pjp.getArgs();
//        for (Object arg : args) {
//            System.out.println("参数为:" + arg);
//        }
//        Object object = pjp.proceed();
//        System.out.println("----------Aspect结束处理----------");
//        System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));
        return "";
    }

}
