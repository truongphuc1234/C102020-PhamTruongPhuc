package com.example.book_management.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {

    @After("execution(public * com.example.book_management.service.BookTrackingService.*(..))")
    public void log(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("%s.%s%s",className, method, args);
        System.out.println();
    }
}
