package com.alicegerman.polynomial;

import java.util.Scanner;

public class PolynomialDemo {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // First polynom
        System.out.println("Enter number of terms for first polynomial:");
        int n1 = scanner.nextInt();

        double[] numbers1 = new double[n1];
        int[] powers1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            System.out.println("Enter x:");
            numbers1[i] = scanner.nextDouble();

            System.out.println("Enter power:");
            powers1[i] = scanner.nextInt();
        }

        Polynomial p = new Polynomial(numbers1, powers1);

        // Second polyno
        System.out.println("Enter number of terms for second polynomial:");
        int n2 = scanner.nextInt();

        double[] numbers2 = new double[n2];
        int[] powers2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            System.out.println("Enter x:");
            numbers2[i] = scanner.nextDouble();

            System.out.println("Enter power:");
            powers2[i] = scanner.nextInt();
        }

        Polynomial q = new Polynomial(numbers2, powers2);

        //Print polynomials 
        System.out.println("p(x) = " + p);
        System.out.println("q(x) = " + q);

        //Operations
        System.out.println("p + q = " + p.plus(q));
        System.out.println("p - q = " + p.minus(q));

        System.out.println("p' = " + p.derivative());
        System.out.println("q' = " + q.derivative());

        System.out.println("p equals q? " + p.equals(q));

        scanner.close();
    }
}
