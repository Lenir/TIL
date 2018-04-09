package io.github.lenir;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("loggerWithAnnotation")
public class LoggerWithAnnotation {

    @Pointcut("within(io.github.lenir.loggable.*)")
    private void pointcutMethod(){
    }

    @Around("pointcutMethod()")
    public Object logAroundAdviseAnnotated(ProceedingJoinPoint jointPoint) throws Throwable{
        // Methid logging advise.
        String signatureStr = jointPoint.getSignature().toShortString();

        long startTime = System.currentTimeMillis();
        System.out.println("< Logger with annotation > " + signatureStr + " started.");
        try{
            Object returnedObj = jointPoint.proceed();
            return returnedObj;
        }finally {
            long endTime = System.currentTimeMillis();
            System.out.println("< Logger with annotation > " + signatureStr + " end. Run time : " + (endTime - startTime));
        }

    }

    @Before("within(io.github.lenir.loggable.*)")
    public void beforeAdvise(){
        System.out.println("< Logger with annotation > Before run advise");
    }
}
