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
@Component
@Aspect
public class MultiAdvicesAllAspect {

    @Pointcut("execution(boolean *.execute(String,..))")
    public void taskExecution(){}

    /**
     * 前置通知
     */
    @Before("taskExecution()")
    public void before(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("前置通知:方法名称"+methodName+",传入参数："+args.length);
    }


    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "taskExecution()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        Object result = null;
        try {
             result = pjp.proceed();//继续调用执行链
            System.out.println("环绕通知:方法："+methodName+",返回结果:"+result);
        } catch (Throwable throwable) {//如果配置了异常通知,则这里需要抛出异常信息
            throw throwable;
        }
        return result;
    }

    /**
     * 后置通知
     * @param jp
     */
    @After("taskExecution()")
    public void after(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("后置通知:方法名称："+methodName+",after method");
    }

    /**
     * 返回通知
     * @param jp
     * @param result
     */
    @AfterReturning(value = "taskExecution()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("返回通知：方法名称："+methodName+",返回结果:"+result);
    }

    /**
     * 异常通知
     * @param jp
     * @param ex
     */
    @AfterThrowing(value = "taskExecution()",throwing = "ex")
    public void afterThrowing(JoinPoint jp,Exception ex){
        String methodName = jp.getSignature().getName();
        System.out.println("异常通知,方法名:"+methodName+"发生的异常ex="+ex);
    }

}
