package com.pen.roadmap.aspect;

import com.pen.roadmap.annotation.RetryIfException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class RetryIfExceptionAspect {

    @Around(value="@annotation(annotation)")
    public Object retryIfException(ProceedingJoinPoint joinPoint, RetryIfException annotation) throws Throwable {

        int i = 0;
        while (i < annotation.retry() - 1) {
            try {
                return joinPoint.proceed();
            } catch (Exception e) {
                System.out.println("exeption");// TODO to be removed
                i++;
            }
        }

        return joinPoint.proceed();
    }
}
