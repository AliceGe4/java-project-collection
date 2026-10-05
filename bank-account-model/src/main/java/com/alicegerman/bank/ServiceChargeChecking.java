package com.alicegerman.bank;

public class ServiceChargeChecking extends CheckingAccount {

	protected double monthlyFee;

	public ServiceChargeChecking(String accountNumber, String ownerName, String idNumber, double balance,
			double monthlyFee) {

		super(accountNumber, ownerName, idNumber, balance);
		this.monthlyFee = monthlyFee;
	}

	@Override
	public void monthlyManagement() {
		balance -= monthlyFee;
	}

	@Override
	public String toString() {
		return super.toString() + " Monthly Fee: " + monthlyFee;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof ServiceChargeChecking))
			return false;

		ServiceChargeChecking other = (ServiceChargeChecking) obj;

		return super.equals(other) && this.monthlyFee == other.monthlyFee;
	}
}
