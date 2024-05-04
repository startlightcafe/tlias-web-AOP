package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect1 {

    //也可以在其他类中引用, 前提是没有设置为 private
    @Pointcut("execution(* com.itheima.service.DeptService.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){
        log.info("before执行了 ...");
    }

    //@Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around前...");

        //1.获取 目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象类名: {}",className);

        //2.获取 目标对象的方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标对象的方法名: {}",methodName);

        //3.获取 目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行时传入的参数: {}", Arrays.toString(args));

        //4.放行 目标方法执行
        Object result = joinPoint.proceed();

        //5.获取 目标方法运行的返回值
        log.info("目标方法运行的返回值: {}",result);

        log.info("around后...");

        //return null;
        return result;
    }


    //@After("pt()")
    public void after(){
        log.info("after...");
    }

    //@AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning...");
    }

    //@AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing...");
    }
}
