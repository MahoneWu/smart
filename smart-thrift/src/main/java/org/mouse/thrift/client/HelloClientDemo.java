package org.mouse.thrift.client;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.mouse.thrift.demo.HelloWorldService;

/**
 * Created by Mahone Wu on 2017/10/9.
 */
public class HelloClientDemo {

    public static final String SERVER_IP = "localhost";

    public static final int SERVER_PORT = 8090;

    public static final int TIMEOUT = 30000;

    public void startClient(String name) {
        TTransport transport = null;
        try{
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            //协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();
            String result = client.sayHello(name);
            System.out.println("Thrift client result  = " + result);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != transport){
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        HelloClientDemo clientDemo = new HelloClientDemo();
        clientDemo.startClient("Mahone");
    }



}
