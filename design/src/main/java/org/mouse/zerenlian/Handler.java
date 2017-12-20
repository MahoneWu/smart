package org.mouse.zerenlian;

/**
 * Created by Mahone Wu on 2017/12/18.
 */
public abstract class Handler {

    /**
     * 持有后继的责任对象
     */
    protected Handler successor;


    public abstract String handleRequest(String user,double free);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
