package org.mouse.spring.aspect;


import org.mouse.framework.annotation.Service;

/**
 * Created by Mahone Wu on 2017/12/14.
 */
@Service
public class CounterImpl implements ICounter {

    @Override
    public String  count() {
        System.out.println("--->=count()");
        return "hello world";
    }
}
