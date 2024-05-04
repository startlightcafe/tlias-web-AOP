package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect1 {

    //也可以在其他类中引用, 前提是没有设置为 private
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){
        log.info("before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around前...");

        Object result = proceedingJoinPoint.proceed();

        log.info("around后...");
        return result;
    }

    @After("pt()")
    public void after(){
        log.info("after...");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing...");
    }
}
