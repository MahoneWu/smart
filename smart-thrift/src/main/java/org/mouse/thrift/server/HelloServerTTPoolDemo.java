package org.mouse.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TServerSocket;
import org.mouse.thrift.demo.HelloWorldImpl;
import org.mouse.thrift.demo.HelloWorldService;

/**
 * Created by Mahone Wu on 2017/10/9.
 */
public class HelloServerTTPoolDemo {

    public static final int SERVER_PORT = 8090;

    public void startServer() {
        System.out.println("TThreadPoolServer start!!!");
        try {
            TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            //简单的线程服务模型,一般用于测试
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
            ttpsArgs.processor(tProcessor);
            ttpsArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TThreadPoolServer(ttpsArgs);
            server.serve();
        }catch (Exception e){
            System.out.println("TThreadPoolServer start error");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HelloServerTTPoolDemo serverDemo = new HelloServerTTPoolDemo();
        serverDemo.startServer();
    }
}


