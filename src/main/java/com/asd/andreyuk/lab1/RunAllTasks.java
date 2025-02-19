package com.asd.andreyuk.lab1;

public class RunAllTasks {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        Task1.main(args);
        Task3.main(args);
        Task4.main(args);
        Task5.main(args);
        Task6.main(args);

        System.out.println("\nOverall Lab1 statistics:");

        utils.stopMeasuring();
    }
}
