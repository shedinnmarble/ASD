package bank.service;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public class EmailSender implements IEmailSender {
    @Override
    public void sendEmail(String from, String to, String tittle, String body) {
        System.out.printf("Email send to: from: %10s, to: %s, tittle: %s, body %s\n", from, to, tittle, body);
    }
}
