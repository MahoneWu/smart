package org.mouse.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Mahone on 2017/8/31.
 */
public class CodecUtil {


    private static final Logger logger = LoggerFactory.getLogger(CodecUtil.class);

    public static  String encodeURL(String source){
        String target;
        try{
            target = URLEncoder.encode(source, "UTF-8");
        }catch (Exception e){
            logger.error("encode url failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }


    public static  String decodeURL(String source){
        String target;
        try{
            target = URLDecoder.decode(source, "UTF-8");
        }catch (Exception e){
            logger.error("encode url failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }



}
