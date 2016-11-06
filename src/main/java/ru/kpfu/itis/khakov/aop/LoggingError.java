package ru.kpfu.itis.khakov.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;



@Aspect
public class LoggingError {
    private static Logger log = Logger.getLogger(LoggingError.class);
    @Around("execution(* ru.kpfu.itis.khakov.controllers.*.*(..))")
    public Object throwException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug( joinPoint.getClass().getName() + " has error in proceed" + e.getMessage());
            return "error";
        }
    }
}
