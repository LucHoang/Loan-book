package com.hsl.logger;

import com.hsl.exception.DuplicateEmailException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }

//    @AfterThrowing(pointcut = "execution(public * com.hsl.service.IBookServie.*(..))", throwing = "e")
//    public void log(JoinPoint joinPoint, Exception e) {
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
//    }

//    @AfterThrowing(pointcut = "execution(public * com.hsl.service.OrderService.*(..))", throwing = "a")
//    public void log(JoinPoint joinPoint, DuplicateEmailException a) {
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, a.getMessage()));
//    }
}