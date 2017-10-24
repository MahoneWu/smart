package org.mouse.spring.one;

/**
 * 监听抓取新闻
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/19
 */
public interface IFXNewsListener {

    public String[] getAvailableNewsIds();


    public FXNewsBean getNewsByPK(String newsId);


    public void postProcessIfNecessary(String newsId);

}
