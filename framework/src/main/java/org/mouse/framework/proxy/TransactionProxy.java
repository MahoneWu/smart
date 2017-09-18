package org.mouse.framework.proxy;

import org.mouse.framework.annotation.Transaction;
import org.mouse.framework.helper.DatebaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by wuhao on 2017/9/17.
 */
public class TransactionProxy implements Proxy {

    public static final Logger logger = LoggerFactory.getLogger(TransactionProxy.class);


    private static  final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };


    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {

        Object result;

        boolean flag = FLAG_HOLDER.get();

        Method method = proxyChain.getTargetMethod();

        if(!flag && method.isAnnotationPresent(Transaction.class)){
            FLAG_HOLDER.set(true);
            try {
                DatebaseHelper.beginTransaction();
                logger.debug("begin transaction");
                result = proxyChain.doProxyChain();
                DatebaseHelper.commitTransaction();
                logger.debug("commit transaction");
            }catch (Exception e){
                DatebaseHelper.rollbackTransaction();
                logger.debug("rollback transaction");
                throw e;
            }finally {
                FLAG_HOLDER.remove();
            }
        }else{
            result = proxyChain.doProxyChain();
        }
        return result;
    }
}
