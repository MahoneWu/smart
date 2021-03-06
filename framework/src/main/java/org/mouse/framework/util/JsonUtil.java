package org.mouse.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mahone  on 2017/8/31.
 */
public class JsonUtil {


    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    /**
     * 对象转换为json
     * @param obj
     * @param <T>
     * @return
     */
    public static  <T> String toJson(T obj){
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        }catch (Exception e){
            logger.error("convert POJO to JSON failure",e);
            throw new RuntimeException(e);
        }
        return json;
    }


    /**
     * json转换为对象
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static  <T> T fromJson(String json ,Class<T> type){
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        }catch (Exception e){
            logger.error("convert JSON  to POJO failure",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }


}
