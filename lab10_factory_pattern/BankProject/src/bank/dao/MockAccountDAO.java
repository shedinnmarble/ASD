package bank.dao;

import bank.domain.Account;

import java.util.Collection;

/**
 * Created by Dewei Xiang on 8/28/2017.
 */
public class MockAccountDAO implements IAccountDAO {
    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public Account loadAccount(long accountnumber) {
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return null;
    }
}
