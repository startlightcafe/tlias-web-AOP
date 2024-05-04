package com.itheima.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //注解何时生效 (运行时生效)
@Target(ElementType.METHOD) //注解作用在哪些地方 (方法上)
public @interface MyLog {
    //自定义注解
}
