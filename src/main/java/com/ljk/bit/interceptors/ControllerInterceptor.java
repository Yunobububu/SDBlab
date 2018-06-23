package com.ljk.bit.interceptors;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.exception.ServiceException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
/**
 * 请求拦截处理类
 *
 *
 */
@Component
public class ControllerInterceptor implements MethodInterceptor {
    private final Logger LOG = LogManager.getLogger(this.getClass());
    @Override
    public String invoke(MethodInvocation invocation) {
        String result = "";
        String paramsStr = "";
        Object  value = null;
        Object valueClass = null;
        Method md = invocation.getMethod();
        valueClass = md.getReturnType();
        try {
            Object[] args = invocation.getArguments();
            paramsStr = this.logRequest(args);
            if(valueClass.equals(ResponseData.class)){
                value = (ResponseData) invocation.proceed();
            }else if(valueClass.equals(String.class)){
                value = (String)invocation.proceed();
            }
        } catch (Throwable e) {
            if (e instanceof ServiceException) {

            } else {

            }
        }
        if (value != null) {
            result = value.toString();
        } else {
            result = "JSON 系统转换出错";
        }
        this.logRequestResponse(md, paramsStr, result);
        return result;
    }
    private String logRequest(Object[] args) {
        if (args == null) {
            return "";
        }
        // 请求参数日志信息
        Map<String, Object> params = new HashMap<String, Object>();
        int i = 1;
        for (Object arg : args) {
            if (!(arg instanceof BindingResult) && !(arg instanceof ModelMap) && !(arg instanceof Model)) {
                if (arg instanceof HttpServletRequest) {
                    HttpServletRequest httpRequest = (HttpServletRequest) arg;
                    Enumeration<?> enume = httpRequest.getParameterNames();
                    if (null != enume) {
                        Map<String, String> hpMap = new HashMap<>();
                        while (enume.hasMoreElements()) {
                            Object element = enume.nextElement();
                            if (null != element) {
                                String paramName = (String) element;
                                String paramValue = httpRequest.getParameter(paramName);
                                hpMap.put(paramName, paramValue);
                            }
                        }
                        params.put("HttpServletRequest", hpMap);
                    }
                } else {
                    try {
                        params.put("arg" + i, JSON.toJSONString(arg));
                        i++;
                    } catch (Throwable e) {
                        System.out.println("不能进行json转换");
                        LOG.warn( "CANNOT trasform to json string:"
                                + arg.getClass().getName());

                    }
                }
            }
        }
        String paramsStr = JSON.toJSONString(params);
        return paramsStr;
    }
    private void logRequestResponse(Method md, String paramsStr, String re) {
        Map<String, String> logMap = new HashMap<String, String>();
        logMap.put("controller.method", md.getDeclaringClass().getSimpleName() + "." + md.getName());
        logMap.put("logReq", paramsStr);
        logMap.put("logRes", re);
//        Logger.info(..., logMap);
        LOG.info(logMap);
    }
    private String printStackTraceToString(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString().replace("\n", " ").replace("\r", " ").replace("\t", " ");
    }
}