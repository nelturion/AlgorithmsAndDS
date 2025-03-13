package com.asd.andreyuk.lab0;

public class LabSpecificUtils {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        int curr = 1, prev = 1;
        for (int i = 0; i < n - 2; i++) {
            int t = curr;
            curr += prev;
            prev = t;
        }
        return curr;
    }
}
