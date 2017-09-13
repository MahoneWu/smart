package org.mouse.test.springaop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after");
    }
}
