package bank.service;

/**
 * Created by dewei.xiang on 7/16/2017.
 */
public class CheckingAccountType implements IAccountType {
    @Override
    public double calculateInterestRate(double balance) {
        if(balance < 1000){
            return 0.015;
        }else{
            return 0.025;
        }
    }
}
