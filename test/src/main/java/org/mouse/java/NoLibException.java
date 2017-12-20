package org.mouse.java;

/**
 * @author wuhao Mahone Wu
 * @date 2017/11/26
 */
public class NoLibException {

    public native void nativeMethod();

    static {
        System.out.println("NoLib");
    }

    public static void main(String[] args) {
        new NoLibException().nativeMethod();
    }

}
