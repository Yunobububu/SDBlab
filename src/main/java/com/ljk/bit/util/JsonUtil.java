package com.ljk.bit.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

    public static  String string2json(String param){
        return JSON.toJSONString(param);
    }


}
