package org.mouse.spring.targetsourcedemo.customer;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Mahone Wu on 2017/11/27.
 */
public class Tester {

    public static void main(String[] args) {
        ITask task1 = new ITask() {
            public void execute() {
                System.out.println("execute in task1...");
            }
        };

        ITask task2 = new ITask() {
            public void execute() {
                System.out.println("execute in task2...");
            }
        };

        ProxyFactory pf = new ProxyFactory();
        TargetSource targetSource = new AlternativeTargetSource(task1, task2);
        pf.setTargetSource(targetSource);
        Object proxy = pf.getProxy();
        ((ITask) proxy).execute();
        ((ITask) proxy).execute();
        ((ITask) proxy).execute();
        ((ITask) proxy).execute();
        ((ITask) proxy).execute();
        ((ITask) proxy).execute();

    }

}
