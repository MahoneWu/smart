package org.mouse.framework.proxy;

/**
 * Created by Mahone Wu on 2017/9/13.
 */
public interface Proxy {


    /**
     * 执行链式代理
     * 所谓链式代理就是可将多个代理通过一条链子串起来，一个个执行，执行顺序取决于添加到链上的先后顺序
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;

}
