package bank.dao;

import bank.domain.Account;

import java.util.Collection;

/**
 * Created by Dewei Xiang on 9/17/2017.
 */
public class TestAccountDAO implements IAccountDAO {
    @Override
    public void saveAccount(Account account) {
        System.out.println("saved Account");
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("updated Account");
    }

    @Override
    public Account loadAccount(long accountnumber) {
        System.out.println("loadAccount Account");
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        System.out.println("getAccounts");
        return null;
    }
}
