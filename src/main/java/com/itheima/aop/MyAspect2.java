package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect2 {

    //也可以在其他类中引用, 前提是没有设置为 private
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt() {
    }

    //匹配含有自定义注解 @MyLog 的方法
    @Pointcut("@annotation(com.itheima.aop.MyLog)")
    public void pt2() {}

    @Before("pt2()")
    public void before() {
        log.info("before执行了 ...");
    }

}
