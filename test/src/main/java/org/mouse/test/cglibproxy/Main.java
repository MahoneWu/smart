package org.mouse.test.cglibproxy;

import org.mouse.test.staticproxy.Hello;
import org.mouse.test.staticproxy.HelloImpl;

/**
 * Created by Mahone Wu on 2017/9/1.
 */
public class Main {

    public static void main(String[] args) {
        //CGLlibProxy cgLlibProxy = new CGLlibProxy();
        Hello helloProxy = CGLlibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("mahone");
        helloProxy.count();
    }

}
