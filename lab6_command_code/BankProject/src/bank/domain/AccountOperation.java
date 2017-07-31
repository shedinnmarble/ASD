package bank.domain;

/**
 * Created by Dewei Xiang on 7/30/2017.
 */
public class AccountOperation {
    long accountnumber;
    long toAccountNumber;
    double money;
    String operationType;
    public AccountOperation(){}
    public AccountOperation(long accountnumber, double money, String operationType) {
        this.accountnumber = accountnumber;
        this.money = money;
        this.operationType = operationType;
    }
    public AccountOperation(long accountnumber,long toAccountNumber, double money, String operationType) {
        this.accountnumber = accountnumber;
        this.money = money;
        this.toAccountNumber = toAccountNumber;
        this.operationType = operationType;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public long getToAccountNumber() {
        return toAccountNumber;
    }

    public double getMoney() {
        return money;
    }



    public String getOperationType() {
        return operationType;
    }


}
