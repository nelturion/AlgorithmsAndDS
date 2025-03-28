package com.asd.andreyuk.lab0;

import java.io.InputStream;
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
        int[] values = customRead();
        int a, b, res;
        assert values != null;
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
        int[] values = customRead();
        int a, b, res;
        assert values != null;
        a = values[0];
        b = values[1];
        res = a + b * b;

        utils.writeIntToFile(taskName, res);
    }

    private static int[] customRead() {
        ClassLoader classLoader = Task1.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + taskName + "/input.txt");
        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            int n = 2;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            return array;
        } else {
            System.out.println("File not found");
            return null;
        }
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
