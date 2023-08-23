package com.LucaSteam.utilities;

import java.util.Scanner;

public class ReadData {
    static Scanner input = new Scanner(System.in);
    public static int readInt(String message) {
        boolean error = true;
        int number = 0;
        do {
            System.out.println(message);
            error = input.hasNextInt();
            if (error) {
                number = input.nextInt();
            } else {
                System.out.println("Error, introduce un número entero");
            }
            input.nextLine();
        } while (!error);
        input.nextLine();
        return number;
    }

    public static int readInt(String message, int min, int max) {
        boolean error = true;
        int number = 0;
        do {
            System.out.println(message);
            error = input.hasNextInt();
            if (error) {
                number = input.nextInt();
                if (number < min || number > max) {
                    error = false;
                    System.out.println("Error, introduce un número entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error, introduce un número entero");
            }
            input.nextLine();
        } while (!error);
        input.nextLine();
        return number;
    }

    public static double readDouble(String message) {
        boolean error = true;
        double number = 0;
        do {
            System.out.println(message);
            error = input.hasNextDouble();
            if (error) {
                number = input.nextDouble();
            } else {
                System.out.println("Error, introduce un número decimal");
            }
            input.nextLine();
        } while (!error);
        return number;
    }

    public static boolean readBoolean(String message) {
        boolean error = true;
        boolean answer = false;
        do {
            System.out.println(message);
            error = input.hasNextBoolean();
            if (error) {
                answer = input.nextBoolean();
            } else {
                System.out.println("Error, introduce un booleano");
            }
            input.nextLine();
        } while (!error);
        return answer;
    }

    public static float readFloat(String message) {
        boolean error = true;
        float number = 0;
        do {
            System.out.println(message);
            error = input.hasNextFloat();
            if (error) {
                number = input.nextFloat();
            } else {
                System.out.println("Error, introduce un número decimal");
            }
            input.nextLine();
        } while (!error);
        return number;
    }

    public static String readString(String message) {
        System.out.println(message);
        String aux = input.nextLine();
        System.out.println(aux);
        return aux;
    }

    public static String readWord(String message) {
        System.out.println(message);
        String aux = input.next();
        input.nextLine();
        return aux;
    }
}