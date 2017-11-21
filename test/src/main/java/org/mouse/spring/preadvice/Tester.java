package org.mouse.spring.preadvice;

/**
 * Created by Mahone Wu on 2017/11/17.
 */
public class Tester implements ITester {

    private boolean busyAsTester;

    @Override
    public boolean isBusyAsTester() {
        return busyAsTester;
    }

    @Override
    public void testSoftware() {
        System.out.println("i will ensure the quality");
    }

    public void setBusyAsTester(boolean busyAsTester) {
        this.busyAsTester = busyAsTester;
    }
}
