package com.ljk.bit.dto;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ResponseData {
    private final String message;
    private final int code;
    private final Map<String, Object> data = new HashMap<String, Object>();

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseData putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    private ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public static ResponseData ok() {
        return new ResponseData(200, "Ok");
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found");
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request");
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }

    public static ResponseData unauthorized() {
        return new ResponseData(401, "unauthorized");
    }

    public static ResponseData serverInternalError() {
        return new ResponseData(500, "Server Internal Error");
    }

    public static ResponseData customerError() {
        return new ResponseData(1001, "customer Error");
    }

    public static ResponseData alreadyExist(){ return  new ResponseData(-1,"already Exist");};
}