package com.alicegerman.bank;

public class SavingsAccount extends BankAccount {

	protected double interestRate;

	public SavingsAccount(String accountNumber, String ownerName, String idNumber, double balance,
			double interestRate) {
		super(accountNumber, ownerName, idNumber, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public void monthlyManagement() {
		balance += balance * interestRate;
	}

	@Override
	public String toString() {
		return super.toString() + " Interest Rate: " + interestRate;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SavingsAccount))
			return false;

		SavingsAccount other = (SavingsAccount) obj;

		return super.equals(other) && this.interestRate == other.interestRate;
	}
}
