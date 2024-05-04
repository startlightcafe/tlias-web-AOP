package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect //代表当前类是AOP类
public class TimeAspect {

    // (返回值类型  包.类或接口.方法)
    @Around("com.itheima.aop.MyAspect1.pt()") //切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1．记录开始时间
        long begin = System.currentTimeMillis();

        //2．调用原始方法运行
        Object result = joinPoint.proceed(); //result为原始方法的返回值

        //3．记录结束时间，计算方法执行耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法耗时: {}毫秒",end-begin);


        return result;
    }
}
