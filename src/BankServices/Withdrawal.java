package BankServices;

public class Withdrawal extends Operation {

	private int code;
	private int date;
	private double value;
	
	private Account account;
	
	public Withdrawal(int code, int date, double value) {
		this.code = code;
		this.date = date;
		this.value = value;
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
	
	public Account getAccount() {
		return account;
	}

	@Override
	public String toString() {
		return this.date+","+this.value+"-";
	}

	
}
