package org.mouse.spring.one;

/**
 * 持久数据
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/19
 */
public class DowJonesNewsPersister implements IFXNewsPersister {

    public void persistNews(FXNewsBean newsBean) {
        System.out.println("store in database");
    }
}
