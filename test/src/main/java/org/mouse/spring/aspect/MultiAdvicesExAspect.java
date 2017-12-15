package org.mouse.spring.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Title: MultiAdvicesAspect
 * @Package org.mouse.spring.aspect
 * @Description: 测试所有的切面advice
 * @author Mahone Wu
 * @date 2017/12/12 16:20
 * @version V1.0
 */
//@Component
@Aspect
public class MultiAdvicesExAspect {

    @Pointcut("execution(* *.execute(..))")
    public void taskExecution(){}

    @Around(value = "taskExecution()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        Object result = null;
        try {
             result = pjp.proceed();
            System.out.println("环绕通知:方法："+methodName+",返回结果:"+result);
        } catch (Throwable throwable) {
            throw throwable;
        }
        return result;
    }


    @AfterThrowing(value = "execution(* *.execute(int))",throwing = "ex")
    public void afterThrowingEx(JoinPoint jp,Exception ex){
        String methodName = jp.getSignature().getName();
        System.out.println("afterThrowingEx 异常通知,方法名:"+methodName+"发生的异常ex="+ex);
    }
}
