package com.heo.lotto.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    
    @Around("execution(* com.heo.lotto..*(..))")
    public Object execu(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        System.out.println("args : " + joinPoint.getArgs().toString());

        try{
            return joinPoint.proceed();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("End : " + joinPoint.toLongString() + " " + timeMs + "ms");
        }
        
    }
}
