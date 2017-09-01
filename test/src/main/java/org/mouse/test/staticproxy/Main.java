package org.mouse.test.staticproxy;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
public class Main {


    public static void main(String[] args) {
        Hello helloProxy = new HelloProxy();
        helloProxy.say("Mahone");
    }

}
