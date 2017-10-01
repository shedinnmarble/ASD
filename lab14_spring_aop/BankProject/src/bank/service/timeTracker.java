package bank.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * Created by Dewei Xiang on 9/17/2017.
 */
public class timeTracker {
    private Object loggingTime(ProceedingJoinPoint call) throws Throwable{
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println(String.format("time to execute %s = %s ms", call.getSignature().getName(), totaltime));
        return retVal;
    }
}
