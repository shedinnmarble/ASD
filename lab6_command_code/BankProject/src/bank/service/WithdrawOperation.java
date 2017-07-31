package bank.service;

import bank.domain.AccountOperation;

import java.util.Stack;

/**
 * Created by Dewei Xiang on 7/30/2017.
 */
public class WithdrawOperation extends AccountOperation implements IAccountOperation{
    Stack<AccountOperation> lastStep = new Stack();

    IAccountService accountService;
    public WithdrawOperation(long accountnumber, double money, String operationType, IAccountService accountService){
        super(accountnumber, money, operationType);
        this.accountService = accountService;
    }
    @Override
    public void execute() {
        AccountOperation ao = new AccountOperation(this.getAccountnumber(), this.getMoney(), "WithdrawOperation");
        lastStep.push(ao);
        accountService.withdraw(this.getAccountnumber(), this.getMoney());
    }

    @Override
    public void undo() {
        if(lastStep.size()>= 1){
            AccountOperation ao =  lastStep.pop();
            // undo operation
            System.out.println("--------------your WithdrawOperation operation undoed, TODO!! --------");
        }
    }
}
