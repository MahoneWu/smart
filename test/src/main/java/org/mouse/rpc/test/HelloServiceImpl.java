package org.mouse.rpc.test;


/**
 * 实现类
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/16
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public String hello(String name) {
        return "Hello " + name;
    }


    @Override
    public String say(String name) {
        return "test";
    }
}
