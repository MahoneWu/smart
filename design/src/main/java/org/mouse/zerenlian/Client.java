package org.mouse.zerenlian;

/**
 * Created by Mahone Wu on 2017/12/18.
 */
public class Client {

    public static void main(String[] args) {

        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        String test1 = h3.handleRequest("张三", 200);
        System.out.println(test1);
        String test2 = h3.handleRequest("张三1", 200);
        System.out.println(test2);
    }

}
