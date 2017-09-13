package org.mouse.test.springaop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
public class GreetingThrowAdvice implements ThrowsAdvice {


    public void afterThrowing(Method method,Object[] args,Object target,Exception e){
        System.out.println("-------------throw exception start----------------");
        System.out.println("target class : " +target.getClass().getName());
        System.out.println("method name :" +method.getName());
        System.out.println("exception message :"+e.getMessage());
        System.out.println("-------------------end------------------");
    }
}
