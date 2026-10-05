package com.alicegerman.bank;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, String ownerName, String idNumber, double balance) {
        super(accountNumber, ownerName, idNumber, balance);
    }

    public void writeCheck(double amount) throws IllegalBalanceException {
        withdraw(amount);
    }

    @Override
    public void monthlyManagement() {
        // No monthly action for a regular checking account
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof CheckingAccount))
            return false;

        return super.equals(obj);
    }
}
