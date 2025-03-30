package com.asd.andreyuk.lab4;

import com.asd.andreyuk.Utils;

public class RunAllTasks {
    public static void main(String[] args) {
        Utils utils = new Utils();
        System.out.println("--- Starting lab4 ---\n");
        utils.startMeasuring();

        Task2.main(args);
        Task4.main(args);
        Task6.main(args);
        Task10.main(args);
        Task12.main(args);
        Task13.main(args);

        System.out.println("\nAll tasks completed. Lab4 statistics:");
        utils.stopMeasuring();
    }
}
