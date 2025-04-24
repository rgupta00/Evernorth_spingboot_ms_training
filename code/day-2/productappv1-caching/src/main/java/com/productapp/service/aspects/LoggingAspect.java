package com.productapp.service.aspects;

import com.productapp.service.ProductServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger= LoggerFactory.getLogger(LoggingAspect.class);
    //JP>PC
    @Around("execution(* com.productapp.service.ProductService*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint)throws Throwable {
        long start= System.currentTimeMillis();
       Object val= proceedingJoinPoint.proceed();
        long end=System.currentTimeMillis();
        logger.info("time taken {} ms",end-start+ " method name "+ proceedingJoinPoint.getSignature().getName());
        return val;
    }
    @AfterThrowing(value = "execution(* *.*.*(..)))",throwing = "e")
    public void logExceptions(Exception e) {
        System.out.println("---------------------------------");
    }
}
