package org.mouse.spring.introduction;


import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by Mahone Wu on 2017/11/20.
 */
public class TesterFeatureIntroductionInterceptor extends DelegatingIntroductionInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("method = "+mi.getMethod());
        return super.invoke(mi);
    }
}
