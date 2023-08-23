package com.LucaSteam.utilities;

public class MathOperation {
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int factorial(int n) {
        int factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial *= i;
        }

        return factorial;
    }

    public static int eurToCent (float eur) {
        return (int) (eur * 100);
    }

    public static int cubo (int n) {
        return n * n * n;
    }

    public static int sum (int a, int b) {
        return a + b;
    }

    public static int rest(int a, int b){
        return a-b;
    }
    public static float div (int a, int b) {
        return (float) a / b;
    }

    public static float mult (int a, int b) {
        return a * b;
    }

    public static int potencia(int num1, int num2) {
        int a = num2 * num2;
        for (int i = 2; i < num2; i++) {
            a *=num2;
        }
        return a;
    }

    public static double raiz(int num1) {
        return Math.pow(num1, 0.5);

    }
}
