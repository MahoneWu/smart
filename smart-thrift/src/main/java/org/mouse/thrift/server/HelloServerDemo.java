package org.mouse.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.mouse.thrift.demo.HelloWorldImpl;
import org.mouse.thrift.demo.HelloWorldService;

/**
 * Created by Mahone Wu on 2017/10/9.
 *
 * http://www.micmiu.com/soa/rpc/thrift-sample/
 */
public class HelloServerDemo {

    public static final int SERVER_PORT = 8090;

    public void startServer() {
        System.out.println("server start!!!");
        try {
            TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            //简单的线程服务模型,一般用于测试
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
        }catch (Exception e){
            System.out.println("server start error");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HelloServerDemo serverDemo = new HelloServerDemo();
        serverDemo.startServer();
    }
}


