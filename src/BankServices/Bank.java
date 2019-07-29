package BankServices;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
	
	private String bankName;
	private int numberOfClients = 1;
	
	private List<Account> accounts = new LinkedList<>();
	
	
	public Bank(String bankName) {
	
		this.bankName = bankName;
	}
	
	public String getName() {
		return bankName;
	}
	
	public int createAccount(String name, int date, double initial) { //done
		Account account = new Account(numberOfClients++,name,date,initial);
		accounts.add(account);
		
		Deposit deposit = new Deposit(accounts.size(), date, initial);
		accounts.get(accounts.size() - 1).addDeposit(deposit);
		
		return accounts.size();
	}
	
	public Account deleteAccount(int code, int date) throws InvalidCode { 
		if(accounts.size() < code) throw new InvalidCode();
		if(accounts.get(code - 1).getDate() < date){ 
			accounts.get(code - 1).setDate(date);
		}
		Withdrawal withdrawal = new Withdrawal(code, date,accounts.get(code - 1).getBalance()); 
		accounts.get(code - 1).closeAccount(withdrawal);
		
		return accounts.get(code - 1);
	}
	
	public Account getAccount(int code) throws InvalidCode { //done
		if(accounts.size() < code) throw new InvalidCode();
		
		return accounts.stream().skip(code - 1).findFirst().orElse(null);
	}

	public void deposit(int code, int date, double value) throws InvalidCode {
		if(accounts.size() < code) throw new InvalidCode();
	
		if(accounts.get(code - 1).getDate() < date) 
			accounts.get(code - 1).setDate(date);
		
		Deposit deposit = new Deposit(code,date,value);
		accounts.get(code - 1).addDeposit(deposit);
	}

	public void withdraw(int code, int date, double value) throws InvalidCode, InvalidValue {
		if(accounts.size() < code) throw new InvalidCode();
		if(accounts.get(code - 1).getBalance() <= value) throw new InvalidValue();
		if(accounts.get(code - 1).getDate() < date) {
			accounts.get(code - 1).setDate(date);
		}
		
		Withdrawal withdrawal = new Withdrawal(code,date,value);
		accounts.get(code - 1).addWithdrawal(withdrawal);
		
	}
	                                                // 8
	public void transfer(int fromCode, int toCode, int date, double value) throws InvalidCode, InvalidValue {
	
		if(accounts.size() < fromCode || accounts.size() < toCode) throw new InvalidCode();
		if(accounts.get(fromCode - 1).getBalance() < value) throw new InvalidValue();//7 va 41 
		if(accounts.get(fromCode - 1).getDate() <= accounts.get(toCode - 1).getDate()){
		
			if(accounts.get(fromCode - 1).getDate() < date) {
			 accounts.get(fromCode - 1).setDate(date);
		}

		Withdrawal withdrawal = new Withdrawal(fromCode,date,value);
		accounts.get(fromCode - 1).addWithdrawal(withdrawal);
		Deposit deposit = new Deposit(toCode, accounts.get(toCode - 1).getDate(), value);
		accounts.get(toCode - 1).addDeposit(deposit);
		
		}
		
	}
	
	public double getTotalDeposit() {
		
		
		
		List<String> st = accounts.stream().map(Account::getMovements)
				.flatMap(l->l.stream()).map(o->o.toString())
				.collect(Collectors.toList());
		double sum = 0;
		 for (String s : st) {
			 	String rightPart = s.split(",")[1];
			 	String doubleString = rightPart.substring(0, rightPart.length()-1);
			 	char operation = rightPart.charAt(rightPart.length()-1);
			 	double value = Double.parseDouble(doubleString);
			 	if(operation=='+')sum+=value;
			 	else if(operation=='-')sum-=value;
				
		}
		 return sum;
			
	}
	
	public List<Account> getAccounts() {
		return accounts.stream().filter(a->a.getBalance() != 0.0).collect(Collectors.toList());
	}
	

	public List<Account> getZeroAccounts() {
		return accounts.stream().filter(a->a.getBalance() == 0.0).collect(Collectors.toList());
	}

	public List<Account> getAccountsByBalance(double low, double high) {
		
		return accounts.stream().filter(a->a.getBalance() > low && a.getBalance() < high).collect(Collectors.toList());
	}
	
	
}
