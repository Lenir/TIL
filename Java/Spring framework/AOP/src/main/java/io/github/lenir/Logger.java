package io.github.lenir;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    public Object logAroundAdvise(ProceedingJoinPoint jointPoint) throws Throwable{
        // Methid logging advise.
        String signatureStr = jointPoint.getSignature().toShortString();

        long startTime = System.currentTimeMillis();
        System.out.println("< Logger > " + signatureStr + " started.");
        try{
            Object returnedObj = jointPoint.proceed();
            return returnedObj;
        }finally {
            long endTime = System.currentTimeMillis();
            System.out.println("< Logger > " + signatureStr + " end. Run time : " + (endTime - startTime));
        }

    }

}
