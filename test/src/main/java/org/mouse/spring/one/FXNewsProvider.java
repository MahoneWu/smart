package org.mouse.spring.one;

import org.mouse.framework.util.ArrayUtil;

/**
 * 提供
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/19
 */
public class FXNewsProvider
{

    private IFXNewsListener newsListener;

    private IFXNewsPersister newsPersister;


    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewsPersister(IFXNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }

    public void getAndPersisterNews(){
        System.out.println("MMMMMMMMMMM");
        String[] newsIds = newsListener.getAvailableNewsIds();

        if(ArrayUtil.isEmpty(newsIds)){
            return;
        }

        for(String newsId : newsIds){
            FXNewsBean fxNewBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(fxNewBean);
            newsListener.postProcessIfNecessary(newsId);
        }


    }

}
