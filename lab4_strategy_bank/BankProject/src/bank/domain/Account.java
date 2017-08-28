package bank.domain;

import bank.service.*;

import java.util.*;


public class Account {
	long accountnumber;
	// account type
	private AccountType accountType;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;
	IEmailSender emailSender = new EmailSender();
	ILoggingService loggingService = new LoggingService();
	ISMSSender smsSender = new SMSSender();
	
	public Account (long accountnr, AccountType accountType){
		this.accountnumber = accountnr;
		this.accountType = accountType;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
		this.customer = this.getCustomer();
		this.notifyCustomer(this.customer, amount,"Deposit");
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);
		this.customer = this.getCustomer();
        this.notifyCustomer(this.customer, amount,"withdraw");
	}
    private void notifyCustomer(Customer customer, double amount, String type){
	    System.out.println("---------------notify customer begin------------------");
        loggingService.log(String.format("%s %s %f, balance is %f", customer.getName(), type, amount, this.getBalance()));
        smsSender.send(String.format("%s %s %f, balance is %f", this.customer.getName(),type, amount, this.getBalance()));
        emailSender.sendEmail("midestone","you","Notification", String.format("%s %s %f, balance is %f", customer.getName(),type, amount, this.getBalance()));
        System.out.println("---------------notify customer end------------------");
	}
	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);
		toAccount.deposit(amount);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public AccountType getAccountType() {
		return accountType;
	}
}
