package com.asd.andreyuk.lab0;

import java.util.Scanner;

/**
 * Solution for task1 in lab0. subtask1 and subtask2 - read inputs from terminal,
 * subtask3 and subtask4 - read inputs from file. The only problem with this solution is that user has to
 * manually change main function.
 */
public class Task1 {
    private static final String taskName = "lab0/task1";

    /**
     * Read inputs from terminal -> split the input line -> print sum.
     */
    public static void subtask1() {
        Scanner scanner = new Scanner(System.in);
        int a, b;

        System.out.println("Enter two integers (in one line): ");
        String s = scanner.nextLine();
        a = Integer.parseInt(s.split(" ")[0]);
        b = Integer.parseInt(s.split(" ")[1]);

        System.out.println(a + b);
    }

    /**
     * Read inputs from terminal -> split the input line -> print sum.
     */
    public static void subtask2() {
        Scanner scanner = new Scanner(System.in);
        int a, b;

        System.out.println("Enter two integers (in one line): ");
        String s = scanner.nextLine();
        a = Integer.parseInt(s.split(" ")[0]);
        b = Integer.parseInt(s.split(" ")[1]);

        System.out.println(a + b * b);
    }

    /**
     * Read input (as integer array) from file using Utils method -> write sum in output.txt file.
     */
    public static void subtask3() {
        Utils utils = new Utils();
        int[] values = utils.readIntArrayFromFile(taskName);
        int a, b, res;
        a = values[0];
        b = values[1];
        res = a + b;

        utils.writeIntToFile(taskName, res);
    }

    /**
     * Read input (as integer array) from file using Utils method -> write sum in output.txt file.
     */
    public static void subtask4() {
        Utils utils = new Utils();
        int[] values = utils.readIntArrayFromFile(taskName);
        int a, b, res;
        a = values[0];
        b = values[1];
        res = a + b * b;

        utils.writeIntToFile(taskName, res);
    }

    /**
     * Run to start all subtasks
     * @param args not used in this method
     */
    public static void main(String[] args) {
        // subtask1();
        // subtask2();
        subtask3();
        subtask4();
    }
}
