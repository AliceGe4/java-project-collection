package com.alicegerman.bank;

public class BankDemo {

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[5];

        accounts[0] = new CheckingAccount("1001", "Margaret", "111111111", 1000);
        accounts[1] = new ServiceChargeChecking("1002", "Bob", "222222222", 1500, 25);
        accounts[2] = new NoServiceChargeChecking("1003", "Charlie", "333333333", 2000, 500);
        accounts[3] = new InterestChecking("1004", "Dana", "444444444", 2500, 500, 0.04);
        accounts[4] = new HighInterestSavings("1005", "Eve", "555555555", 3000, 0.06, 1000);

        System.out.println("> Initial Accounts <");

        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }

        System.out.println("\n> Performing Operations <");

        for (BankAccount acc : accounts) {

            try {

                System.out.println("\nBefore operation:");
                System.out.println(acc);

                acc.deposit(200);

                System.out.println("After deposit of 200:");
                System.out.println(acc);

                acc.withdraw(300);

                System.out.println("After withdraw of 300:");
                System.out.println(acc);

                acc.monthlyManagement();

                System.out.println("After monthly management:");
                System.out.println(acc);

                // Special test for checking accounts
                if (acc instanceof CheckingAccount) {

                    CheckingAccount check = (CheckingAccount) acc;

                    System.out.println("Writing check for 100");
                    check.writeCheck(100);

                    System.out.println("After writeCheck:");
                    System.out.println(check);
                }

            } catch (IllegalBalanceException e) {

                System.out.println("Operation failed: " + e.getMessage());
            }
        }

        System.out.println("\n> Testing equals() <");

        BankAccount test1 = new CheckingAccount("2000", "John", "999999999", 1000);
        BankAccount test2 = new CheckingAccount("2000", "John", "999999999", 1000);

        if (test1.equals(test2)) {
            System.out.println("Accounts are equal.");
        } else {
            System.out.println("Accounts are NOT equal.");
        }
    }
}
