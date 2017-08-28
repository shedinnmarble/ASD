package bank.service;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public class SMSSender implements ISMSSender {
    @Override
    public void send(String text) {
        System.out.println("SMS Send " + text);
    }
}
