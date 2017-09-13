package org.mouse.test.springaspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
@Aspect
@Component
public class GreetingAspectTag {


    /**
     * 拦截
     * 第一个"*"表示方法的返回值是任意的；
     * 第二个"*"表示匹配该类中所有的方法；
     * (..)表示方法的参数是任意的
     * @param pjp
     * @return
     * @throws Throwable
     */
     @Around("@annotation(org.mouse.test.springaspectj.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        //before();
        Object result = pjp.proceed();
       // after();
        return result;
    }





    @Before("execution(* org.mouse.test.springaspectj.GreetingImpl.say(..))")
    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }



}
