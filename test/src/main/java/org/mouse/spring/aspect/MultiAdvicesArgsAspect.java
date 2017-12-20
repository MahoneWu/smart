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
public class MultiAdvicesArgsAspect {

    @Pointcut("execution(boolean *.execute(String,..)) && args(taskName)")
    public void taskExecution(String taskName){}

    @Before("taskExecution(taskName)")
    public void before(String taskName){
        System.out.println("before args="+taskName);
    }


}
