package org.mouse.spring.one;

/**
 * @author wuhao Mahone Wu
 * @date 2017/10/19
 */
public class DowJonesNewsListener implements IFXNewsListener {


    public String[] getAvailableNewsIds(){
        System.out.println("==getAvailableNewsIds()===");
        return null;
    }


    public FXNewsBean getNewsByPK(String newsId) {
        return null;
    }


    public void postProcessIfNecessary(String newsId) {
        System.out.println("----");
    }
}
