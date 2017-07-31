package bank.service;

import bank.domain.AccountOperation;

import java.util.Stack;

/**
 * Created by Dewei Xiang on 7/30/2017.
 */
public class TransforOperation extends AccountOperation implements IAccountOperation {
    Stack<AccountOperation> lastStep = new Stack();

    IAccountService accountService;
    public TransforOperation(  long accountnumber, long toAccount, double money, String operationType, IAccountService accountService){
        super(accountnumber, toAccount, money, operationType);
        this.accountService = accountService;
    }
    @Override
    public void execute() {
        AccountOperation ao = new AccountOperation(this.getAccountnumber(), this.getMoney(), "TransforOperation");
        lastStep.push(ao);
        accountService.transferFunds(this.getAccountnumber(),this.getToAccountNumber(), this.getMoney(), "transfer");
    }

    @Override
    public void undo() {
        if(lastStep.size()>= 1){
            AccountOperation ao =  lastStep.pop();
            // undo operation
            System.out.println("--------------your TransforOperation operation undoed, TODO!! --------");
        }
    }
}
