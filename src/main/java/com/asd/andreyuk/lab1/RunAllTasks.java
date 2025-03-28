package com.asd.andreyuk.lab1;

public class RunAllTasks {
    public static void main(String[] args) {
        Utils utils = new Utils();
        System.out.println("--- Starting lab1 ---\n");
        utils.startMeasuring();

        Task1.main(args);
        Task3.main(args);
        Task4.main(args);
        Task5.main(args);
        Task6.main(args);

        System.out.println("\nAll tasks completed. Lab1 statistics:");
        utils.stopMeasuring();
        System.out.println();
    }
}
