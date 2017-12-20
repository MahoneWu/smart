package org.mouse.owner;

/**
 * Created by Mahone Wu on 2017/12/19.
 */
public class Main {
    public static void main(String[] args) {
        BugHandler bugHandler1 = new ActivityDevBugHandler();
        BugHandler bugHandler2 = new GatewayDevBugHandler();
        BugHandler bugHandler3 = new MobileDevBugHandler();
        bugHandler3.setBugHandler(bugHandler2);
        bugHandler2.setBugHandler(bugHandler1);
        String str = bugHandler1.bug("activity-1");
        System.out.println(str);
    }
}
