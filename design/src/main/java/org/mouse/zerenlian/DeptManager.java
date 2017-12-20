package org.mouse.zerenlian;

/**
 * Created by Mahone Wu on 2017/12/18.
 */
public class DeptManager extends Handler {

    public String handleRequest(String user, double free) {

        String str = "";
        if(free <= 1000){
            if("张三".equals(user)){
                str = "成功批准";
            }else{
                str = "部门经理不批准";
            }
        }else{
            if(getSuccessor() != null){
                return getSuccessor().handleRequest(user,free);
            }
        }
        return str;
    }
}
