package com.asd.andreyuk.lab0;

import com.asd.andreyuk.Utils;

import static com.asd.andreyuk.lab0.LabSpecificUtils.fibonacci;

/**
 * This is a solution of task 2 from lab 0
 */
public class Task2 {
    private static final String taskName = "lab0/task2";

    /**
     * This is a main method for this solution. It reads a number from a file and puts a number from Fibonacci
     * sequence that stands at given index in another file.
     *
     * @param args arguments not used in this solution.
     */
    public static void main(String[] args) {
        Utils util = new Utils();
        util.startMeasuring();

        int n = util.readIntFromFile(taskName);
        int res;

        if (n <= 0) {
            res = 0;
        } else {
            res = fibonacci(n);
        }
        util.writeIntToFile(taskName, res);

        util.stopMeasuring();
    }
}
