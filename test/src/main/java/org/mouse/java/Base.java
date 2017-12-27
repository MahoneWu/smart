package org.mouse.java;

/**
 * Created by Mahone Wu on 2017/12/27.
 */
public class Base {

    private void printPrivate(){
        System.out.println("private");
    }

    void print(){
        System.out.println("default");
    }

    protected void printProtected(){
        System.out.println("protected");
    }

    public void printPublic(){
        System.out.println("protected");
    }

}
