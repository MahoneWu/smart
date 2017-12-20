package org.mouse.owner;

/**
 * Created by Mahone Wu on 2017/12/19.
 */
public abstract class BugHandler {

    protected BugHandler bugHandler;

    public abstract String bug(String name);


    public BugHandler getBugHandler() {
        return bugHandler;
    }

    public void setBugHandler(BugHandler bugHandler) {
        this.bugHandler = bugHandler;
    }
}
