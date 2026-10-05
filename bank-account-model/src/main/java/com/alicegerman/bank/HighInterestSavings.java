package com.alicegerman.bank;

public class HighInterestSavings extends SavingsAccount {

	protected double minBalance;

	public HighInterestSavings(String accountNumber, String ownerName, String idNumber, double balance,
			double interestRate, double minBalance) {
		super(accountNumber, ownerName, idNumber, balance, interestRate);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	@Override
	public void monthlyManagement() {
		if (balance >= minBalance) {
			balance += balance * interestRate;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " Minimum Balance: " + minBalance;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HighInterestSavings))
			return false;

		HighInterestSavings other = (HighInterestSavings) obj;

		return super.equals(other) && this.minBalance == other.minBalance;
	}
}
