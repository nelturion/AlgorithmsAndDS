package com.asd.andreyuk.lab3;

import com.asd.andreyuk.Utils;

public class RunAllTasks {
    public static void main(String[] args) {
        Utils utils = new Utils();
        System.out.println("--- Starting lab3 ---\n");
        utils.startMeasuring();

        Task1.main(args);
        Task2.main(args);
        Task3.main(args);
        Task5.main(args);
        Task6.main(args);

        System.out.println("\nAll tasks completed. Lab3 statistics:");
        utils.stopMeasuring();
    }
}
