package bank.service;

import java.util.Collection;

import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;

	
	public AccountService(){
//		accountDAO=new AccountDAO();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		getAccountDAO().saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = getAccountDAO().loadAccount(accountNumber);
		account.deposit(amount);
		getAccountDAO().updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = getAccountDAO().loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return getAccountDAO().getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = getAccountDAO().loadAccount(accountNumber);
		account.withdraw(amount);
		getAccountDAO().updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = getAccountDAO().loadAccount(fromAccountNumber);
		Account toAccount = getAccountDAO().loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		getAccountDAO().updateAccount(fromAccount);
		getAccountDAO().updateAccount(toAccount);
	}

	public IAccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
}
