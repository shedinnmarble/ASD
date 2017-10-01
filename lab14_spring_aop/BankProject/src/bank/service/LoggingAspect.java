package bank.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
    private void daoLog(JoinPoint pjp) {

        System.out.println(String.format("DAO log: %s called", pjp.getSignature().getName()));

    }
    private Object loggingTime(ProceedingJoinPoint call) throws Throwable{
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println(String.format("Service Log: time to execute %s = %s ms", call.getSignature().getName(), totaltime));
        return retVal;
    }
}
