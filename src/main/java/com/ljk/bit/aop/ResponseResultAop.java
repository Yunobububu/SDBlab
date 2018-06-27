package com.ljk.bit.aop;

import com.ljk.bit.dto.ResponseData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


@Component
@Aspect
public class ResponseResultAop {
    private final Logger LOG = LogManager.getLogger(this.getClass());
    @Pointcut("execution(* com.ljk.bit.web.*.*(..))")
    public void aroundMethod(){}
    @Around("aroundMethod()")
    public Object around(ProceedingJoinPoint pjt) throws Throwable {
        LOG.info("before method invoking");
        BindingResult bindingResult = null;
        for(Object arg:pjt.getArgs()){
            if(arg instanceof BindingResult){
                bindingResult = (BindingResult) arg;
            }
        }

        if(bindingResult != null){
            if(bindingResult.hasErrors()){
                String errorInfo = "["+bindingResult.getFieldError().getField() +"]"+ bindingResult.getFieldError().getDefaultMessage();
                LOG.info("error:{}",bindingResult.getFieldError().getDefaultMessage());
                return ResponseData.badRequest().putDataValue("errorInfo",errorInfo);
            }
        }
        return pjt.proceed();
    }
}
