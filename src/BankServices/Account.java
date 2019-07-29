package BankServices;

import java.util.LinkedList;
import java.util.List;

public class Account {
	
	private String name;
	private int date;
	private double initial;
	private double balance;
	private double transferMoney;
	private int numOfClient;
	
	private List<Deposit> deposits = new LinkedList<>();
	private List<Withdrawal> withdrawals = new LinkedList<>();
	private List<Operation> operations = new LinkedList<>();
	
	public Account(int numOfClient,String name, int date, double initial) {
		this.numOfClient = numOfClient;
		this.name = name;
		this.date = date;
		this.initial = initial;
		this.balance = 0;
		
		
	
	}
	
	public List<Operation> getMovements() {
		return operations;//.stream().collect(Collectors.toList());//.stream().sorted().collect(Collectors.toList());
	}

	public void addDeposit(Deposit deposit) {
		deposits.add(deposit);
		operations.add(deposit);
		
		this.balance += deposit.getValue();
	}
	
	public List<Deposit> getDeposits() {
		return deposits;//.stream().sorted().collect(Collectors.toList());
	}
	
	public void addWithdrawal(Withdrawal withdrawal) {
		withdrawals.add(withdrawal);
		operations.add(withdrawal);
		this.balance -= withdrawal.getValue();
		
	}

	public List<Withdrawal> getWithdrawals() {
		return withdrawals;//.stream().sorted().collect(Collectors.toList());
	}
	public String getName() {
		return name;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public int getDate() {
		return date;
	}
	
	public double getInitial() {
		return initial;
	}

	public double getBalance() {
		return balance;
	}
	
	public double getTransferMoney() {
		return transferMoney;
	}

	public String toString() {
		return this.numOfClient+", "+name + ", " + date + ", " + balance;
	}
	public double closeAccount(Withdrawal withdrawal) {
	
        operations.add(withdrawal);
		this.balance -= this.balance;
		
		return this.balance;	
	
	}
		
	
}
