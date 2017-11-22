package org.mouse.spring.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Mahone Wu on 2017/11/16.
 */
public class TestAfterReturnAdvice  implements AfterReturningAdvice {


    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(returnValue);
        System.out.println(args);
        System.out.println(target);
        System.out.println(method.getName());
    }
}
