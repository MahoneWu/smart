package org.mouse.threadlocal.demo01;

/**
 * Created by Mahone Wu on 2017/9/15.
 */
public class ClientThread extends Thread {


    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for(int i = 0 ; i <3 ;i++){
            System.out.println(Thread.currentThread().getName()  + " => " +sequence.getNumber());
        }
    }
}
