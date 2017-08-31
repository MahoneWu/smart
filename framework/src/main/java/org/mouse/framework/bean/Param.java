package org.mouse.framework.bean;

import org.mouse.framework.util.CastUtil;

import java.util.Map;

/**
 * Created by Mahone on 2017/8/31.
 */
public class Param {


    private Map<String, Object> paramMap;

    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
