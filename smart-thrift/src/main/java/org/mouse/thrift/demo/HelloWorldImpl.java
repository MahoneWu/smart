package org.mouse.thrift.demo;

import org.apache.thrift.TException;

/**
 * Created by Mahone Wu on 2017/10/9.
 */
public class HelloWorldImpl implements HelloWorldService.Iface {

    public HelloWorldImpl() {
    }

    public String sayHello(String username) throws TException {
        return "hi," + username + "test thrift";
    }


}
