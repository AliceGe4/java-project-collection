package com.alicegerman.bank;

public class NoServiceChargeChecking extends CheckingAccount {

	protected double minBalance;

	public NoServiceChargeChecking(String accountNumber, String ownerName, String idNumber, double balance,
			double minBalance) {

		super(accountNumber, ownerName, idNumber, balance);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	@Override
	public void withdraw(double amount) throws IllegalBalanceException {
		if (balance - amount < minBalance || balance - amount < 0) {
			throw new IllegalBalanceException("Balance cannot go negative");
		}
		balance -= amount;
	}

	@Override
	public void monthlyManagement() {
		// No monthly action for a no service checking account
	}

	@Override
	public String toString() {
		return super.toString() + " Minimum Balance: " + minBalance;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof NoServiceChargeChecking))
			return false;

		NoServiceChargeChecking other = (NoServiceChargeChecking) obj;

		return super.equals(other) && this.minBalance == other.minBalance;
	}
}
