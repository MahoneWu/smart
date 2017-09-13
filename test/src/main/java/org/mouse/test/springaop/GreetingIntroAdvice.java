package org.mouse.test.springaop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements  Apology {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    public void saySorry(String name) {
        System.out.println("sorry " + name);
    }
}
