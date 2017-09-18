package org.mouse.threadlocal.demo02;


import org.mouse.threadlocal.demo01.ClientThread;
import org.mouse.threadlocal.demo01.Sequence;
import org.mouse.threadlocal.demo01.SequenceB;

/**
 * Created by wuhao on 2017/9/17.
 */
public class SequenceC implements Sequence {

    public static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>(){
        @Override
        protected Integer initiaValue() {
            return 0;
        }
    };


    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get()+1);
        return numberContainer.get();
    }


    public static void main(String[] args) {
        Sequence sequence = new SequenceC();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }





}
