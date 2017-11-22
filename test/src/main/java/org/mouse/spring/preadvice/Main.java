package org.mouse.spring.preadvice;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by Mahone Wu on 2017/11/17.
 */
public class Main {

    public static void main(String[] args) {
        ITester delegate = new Tester();
        DelegatingIntroductionInterceptor interceptor = new DelegatingIntroductionInterceptor(delegate);
        //进行织入
       // ProxyFactory weave = new ProxyFactory();
//        ITester tester = (ITester) Weaver.weave(developer).with(interceptor).getProxy();
//        tester.testSoftware();

    }

}
