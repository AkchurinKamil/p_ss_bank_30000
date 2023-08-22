package com.bank.history.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.bank.history.*.*.*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        final Signature signature = joinPoint.getSignature();
        final String methodName = signature.getName();
        final String signatureString = signature.toString();
        final String arguments = Arrays.toString(joinPoint.getArgs());
        logger.info("Method called: {} with arguments: {} \nand the full toString: {}",
                methodName, arguments, signatureString);
    }

    @AfterReturning(pointcut = "execution(* com.bank.history.*.*.*(..))", returning = "result")
    public void logAfterMethodCall(JoinPoint joinPoint, Object result) {
        final Signature signature = joinPoint.getSignature();
        final String methodName = signature.getName();
        final String signatureString = signature.toString();
        final String arguments = Arrays.toString(joinPoint.getArgs());
        logger.info("Method called: {} with arguments: {} \nand the full toString: {} \nreturned result: {} --> {}",
                methodName, arguments, signatureString, result.getClass().getName(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.bank.history.*.*.*(..))", throwing = "ex")
    public void logAfterExceptionThrown(JoinPoint joinPoint, Throwable ex) {
        final Signature signature = joinPoint.getSignature();
        final String methodName = signature.getName();
        final String signatureString = signature.toString();
        final String arguments = Arrays.toString(joinPoint.getArgs());
        logger.error("Method called: {} with arguments: {} \nand the full toString: {} \nthe exception is: {}",
                methodName, arguments, signatureString, ex.getMessage());
    }

}
