package bank.service;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public class LoggingService implements ILoggingService {
    @Override
    public void log(String text) {
        System.out.println("Logging Service: "+ text);
    }
}
