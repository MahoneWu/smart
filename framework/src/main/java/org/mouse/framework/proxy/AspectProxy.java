package org.mouse.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
public abstract class AspectProxy implements Proxy{

    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        return null;
    }



    

}
