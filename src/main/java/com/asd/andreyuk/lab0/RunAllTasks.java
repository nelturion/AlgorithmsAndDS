package com.asd.andreyuk.lab0;

import com.asd.andreyuk.Utils;

public class RunAllTasks {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        Task1.main(args);
        Task2.main(args);
        Task3.main(args);

        System.out.println("\nOverall lab0 performance:");
        utils.stopMeasuring();
    }
}
