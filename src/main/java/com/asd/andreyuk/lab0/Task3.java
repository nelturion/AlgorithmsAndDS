package com.asd.andreyuk.lab0;

/**
 * This is a solution of task 3 from lab 0
 */
public class Task3 {
    private static final String taskName = "lab0/task3";
    /**
     * Reads a number from a file and puts the last digit of
     * the Fibonacci sequence number (it is very large, therefore it does not need to calculate the entire number)
     *
     * @param args not used in this solution.
     */
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();
        int n = utils.readIntFromFile(taskName);

        int prev = utils.fibonacci(1) % 10;
        int curr = utils.fibonacci(2) % 10;

        //keep going in cycle until n
        for (int i = 1; i < n-1; i++) {
            int t = curr;
            curr = (prev + curr) % 10;
            prev = t;
        }

        utils.writeIntToFile(taskName, curr);
        utils.stopMeasuring();
    }
}
