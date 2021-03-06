package org.mouse.test.staticproxy;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
public class HelloProxy implements Hello{

    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }


    public int count() {
        return 1;
    }

    public void say(String name) {

        before();
        hello.say(name);
        after();
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}
