package com.asd.andreyuk.lab3;

import com.asd.andreyuk.Utils;

public class InputFileGenerator {
    /**
     * Этот класс необходим исключительно для генерации больших массивов данных для алгоритма quickSort,
     * чтобы проверить скорость работы разных его типов
     *
     * @param args
     */
    public static void main(String[] args) {
        Utils.generateRandomArray("lab3/task1", 100_000);
        // if value is too big, StackOverflowError called (cause - recursion depth)
    }
}
