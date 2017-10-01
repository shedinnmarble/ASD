package customers;
import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.aop.*;
/**
 * Created by Dewei Xiang on 9/17/2017.
 */
public class SendEmailAPOLog implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(String.format("%s method = %s address = %s, message = %s out going server = %s",
                new Date(), method.getName(), args[0], args[1], ((EmailSender)target).getOutgoingMailServer()) );
    }
}
