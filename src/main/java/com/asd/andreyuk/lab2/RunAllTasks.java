package com.asd.andreyuk.lab2;

import com.asd.andreyuk.Utils;

public class RunAllTasks {
    public static void main(String[] args) {
        Utils utils = new Utils();
        System.out.println("--- Starting lab2 ---\n");
        utils.startMeasuring();

        Task1.main(args);
        Task3.main(args);
        Task4.main(args);
        Task5.main(args);
        Task8.main(args);

        System.out.println("\nAll tasks completed. Lab2 statistics:");
        utils.stopMeasuring();
        System.out.println();
    }
}
