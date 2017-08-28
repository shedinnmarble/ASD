package bank.service;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public interface IEmailSender {
    void sendEmail(String from, String to, String tittle, String body);
}
