package org.mouse.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Mahone on 2017/8/30.
 */
public class Request {


    /**
     * 请求方法
     */
    private String requestMethod;


    /**
     * 请求路径
     */
    private String requestPath;


    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }



}
