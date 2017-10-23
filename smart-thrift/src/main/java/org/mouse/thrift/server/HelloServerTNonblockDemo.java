package org.mouse.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.mouse.thrift.demo.HelloWorldImpl;
import org.mouse.thrift.demo.HelloWorldService;

/**
 * Created by Mahone Wu on 2017/10/9.
 */
public class HelloServerTNonblockDemo {

    public static final int SERVER_PORT = 8090;

    public void startServer() {
        System.out.println("TNonblock server start!!!");
        try {
            TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            //简单的线程服务模型,一般用于测试
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(SERVER_PORT);
            TNonblockingServer.Args tnArgs = new TNonblockingServer.Args(serverTransport);
            tnArgs.processor(tProcessor);
            tnArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TNonblockingServer(tnArgs);
            server.serve();
        }catch (Exception e){
            System.out.println("TNonblock server start error");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HelloServerTNonblockDemo serverDemo = new HelloServerTNonblockDemo();
        serverDemo.startServer();
    }
}


