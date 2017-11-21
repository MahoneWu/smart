package org.mouse.spring.introduction;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Created by Mahone Wu on 2017/11/20.
 */
public class Main {

    public static void main(String[] args) {
        ProxyFactory weaver = new ProxyFactory(new Developer());
        weaver.setInterfaces(new Class[]{IDeveloper.class,ITester.class});
        TesterFeatureIntroductionInterceptor advice = new TesterFeatureIntroductionInterceptor();
//        weaver.addAdvice(advice);
        DefaultIntroductionAdvisor advisor = new DefaultIntroductionAdvisor(advice,advice);
        weaver.addAdvisor(advisor);


        Object proxy = weaver.getProxy();
        ((ITester) proxy).testSoftWare();
        ((IDeveloper) proxy).delelopSoftware();

    }

}
