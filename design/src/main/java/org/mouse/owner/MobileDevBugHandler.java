package org.mouse.owner;

/**
 * Created by Mahone Wu on 2017/12/19.
 */
public class MobileDevBugHandler extends BugHandler {

    public String bug(String name) {
        String bug = "";
        if("mobile-1".equals(name)){
             bug ="这个bug是app移动组" + name + "的bug";
        }else {
            getBugHandler().bug(name);
        }
        return bug;
    }
}
