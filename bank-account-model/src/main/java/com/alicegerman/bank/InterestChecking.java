package com.alicegerman.bank;

public class InterestChecking extends NoServiceChargeChecking {

	protected double interestRate;

	public InterestChecking(String accountNumber, String ownerName, String idNumber, double balance, double minBalance,
			double interestRate) {
		super(accountNumber, ownerName, idNumber, balance, minBalance);
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
		if (!(obj instanceof InterestChecking))
			return false;

		InterestChecking other = (InterestChecking) obj;

		return super.equals(other) && this.interestRate == other.interestRate;
	}
}
