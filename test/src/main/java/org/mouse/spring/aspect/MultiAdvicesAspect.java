package org.mouse.spring.aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Title: MultiAdvicesAspect
 * @Package org.mouse.spring.aspect
 * @Description: 测试所有的切面advice
 * @author Mahone Wu
 * @date 2017/12/12 15:42
 * @version V1.0
 */
//@Component
@Aspect
public class MultiAdvicesAspect {

    @Pointcut("execution(boolean *.execute(String,..))")
    public void taskExecution(){}

    @Before("taskExecution()")
    public void beforeOne(){
        System.out.println("before one");
    }

    @Before("taskExecution()")
    public void beforeTwo(){
        System.out.println("before two");
    }

    @AfterReturning("taskExecution()")
    public void afterReturningOne(){
        System.out.println("after returing one");
    }

    @AfterReturning("taskExecution()")
    public void afterReturningTwo()
    {
        System.out.println("after returing two");
    }
}
