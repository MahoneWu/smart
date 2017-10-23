package org.mouse.rpc.customer;

import org.mouse.rpc.provider.RpcFramework;
import org.mouse.rpc.test.HelloService;

/**
 * 消费端
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/16
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.hello("World" + i);
            String say = service.say("123");
            System.out.println(hello);
            Thread.sleep(10000);
        }
    }

}
