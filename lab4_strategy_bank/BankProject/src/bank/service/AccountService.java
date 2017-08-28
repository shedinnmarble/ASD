package bank.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.AccountType;
import bank.domain.Customer;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;

	
	public AccountService(){
		accountDAO=new AccountDAO();
	}

	public Account createAccount(long accountNumber, String customerName, AccountType accountType) {
		Account account = new Account(accountNumber, accountType);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}



	public void addInterest(Collection<Account> accountCollection) {
        List<Long> accountNumbers = accountCollection.stream().map( account -> account.getAccountnumber()).collect(Collectors.toList());
	    for(long accountNumber: accountNumbers){
            double balance = this.getAccount(accountNumber).getBalance();
            AccountType accountType= this.getAccount(accountNumber).getAccountType();
            IAccountType iAccountType = null;
            switch (accountType){
                case SAVING:
                    iAccountType = new SavingAccountType();
                    break;
                case CHECKING:
                    iAccountType = new SavingAccountType();
                    break;
                default:
                    iAccountType = null;
            }
            if(iAccountType != null){
                double interestRate = iAccountType.calculateInterestRate(balance);
                // suppose this is a yearly interest, and this is just a demo to show the Strategy Design pattern
                double interest = balance * interestRate * 1;
                // use deposit to add interest to their acount
                this.deposit(accountNumber, interest);
            }
        }

	}
}
