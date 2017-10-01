package customers;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * Created by Dewei Xiang on 9/17/2017.
 */
public class DAOTimeTrackAOP implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getMethod().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println(String.format("time to execute %s = %s ms", call.getMethod().getName(), totaltime));
        return retVal;
    }
}
