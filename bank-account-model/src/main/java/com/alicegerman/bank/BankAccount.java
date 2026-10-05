package com.alicegerman.bank;

public abstract class BankAccount {

	protected String accountNumber;
    protected String ownerName;
    protected String idNumber;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName, String idNumber, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.idNumber = idNumber;
        this.balance = balance;

    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
    
    public String getIdNumber() {
        return idNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws IllegalBalanceException {
        if(balance - amount < 0) {
            throw new IllegalBalanceException("Balance cannot go negative");
        }
        balance -= amount;
    }

    public abstract void monthlyManagement();

    @Override
    public String toString() {
        return "Account: " + accountNumber +
               " Owner: " + ownerName +
               " Balance: " + balance +
               " ID: " + idNumber;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof BankAccount))
            return false;

        BankAccount other = (BankAccount) obj;

        return this.accountNumber.equals(other.accountNumber);
    }
}
