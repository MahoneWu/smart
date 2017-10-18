package org.mouse.rpc.provider;

import org.mouse.rpc.test.HelloService;
import org.mouse.rpc.test.HelloServiceImpl;

/**
 * 暴露服务
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/16
 */
public class RpcProvider {


    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }


}
