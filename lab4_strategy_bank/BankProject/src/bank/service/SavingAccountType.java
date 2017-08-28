package bank.service;

/**
 * Created by dewei.xiang on 7/16/2017.
 */
public class SavingAccountType implements IAccountType{
    @Override
    public double calculateInterestRate(double balance) {
        if( balance < 1000){
            return 0.01;
        }else if(balance > 1000 && balance < 5000){
            return 0.02;
        }else{
            return 0.04;
        }
    }
}
