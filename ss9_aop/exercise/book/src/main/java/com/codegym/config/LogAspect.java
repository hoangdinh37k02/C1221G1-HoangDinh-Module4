package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Locale;

@Component
@Aspect
public class LogAspect {
@Pointcut("execution(* com.codegym.controller.BookController.book*(..))")
    public void allMethodPointCut(){}

    @Pointcut("execution(* com.codegym.controller.BookController.home(..))")
    public void methodPointCut(){}
    @Before("methodPointCut()")
    public void beforeCallHome(JoinPoint joinPoint){
        System.err.println("Start method name: "+joinPoint.getSignature().getName()+
                ", Time: "+ LocalDateTime.now());
    }


    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: "+joinPoint.getSignature().getName()+
                ", Time: "+ LocalDateTime.now());
    }
    @AfterReturning("allMethodPointCut()")
    public void afterReturningCallMethod(JoinPoint joinPoint){
        System.err.println("End method name: "+joinPoint.getSignature().getName()+
                ", Time: "+ LocalDateTime.now());
    }
}
