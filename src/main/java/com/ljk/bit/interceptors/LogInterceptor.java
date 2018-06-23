package com.ljk.bit.interceptors;

import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.util.JWT;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Component
public class LogInterceptor implements MethodInterceptor{
    private final Logger LOG = LogManager.getLogger("login");
    @Override
    public String invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(LOG);
        Method method = methodInvocation.getMethod();
        String token = (String)methodInvocation.getArguments()[1];
        LoginInfo loginInfo = JWT.unsign(token,LoginInfo.class);
        String userID = loginInfo.getUserID();
        if(LOG != null){
            String message = "userID: "+ userID + " logInTime:" + LocalDateTime.now();
            LOG.info(message);
        }
        methodInvocation.proceed();
        return null;
    }
}
