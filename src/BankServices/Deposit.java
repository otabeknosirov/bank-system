package BankServices;

public class Deposit extends Operation{

	private int code;
	private int date;
	private double value;
	
	private Account account;
	
	public Deposit(int code, int date, double value) {
		this.code = code;
		this.date = date;
		this.value = value;
	}	
	
	public Account getAccount() {
		return account;
	}
	
	public int getCode() {
		return code;
	}
	
	public int getDate() {
		return date;
	}
	
	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		
		return this.date + "," +this.value+"+";
	}
}
