package com.asd.andreyuk.lab2;

import com.asd.andreyuk.Utils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int[] arrayA = Objects.requireNonNull(customRead())[0];
        int[] arrayB = Objects.requireNonNull(customRead())[1];

        //int[] result = naiveMultiplyPolynomials(arrayA, arrayB);
        int[] result = multiplyPolynomials(arrayA, arrayB);

        utils.writeIntegersArrayToFile("lab2/task8", result);
        utils.stopMeasuring();
    }

    private static int[][] customRead() {
        ClassLoader classLoader = Task8.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + "lab2/task8" + "/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            // это чтобы прочитать данные и забыть про них
            int n = scanner.nextInt();
            int[][] arrays = new int[n][n];
            for (int i = 0; i < n; i++) {
                arrays[0][i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arrays[1][i] = scanner.nextInt();
            }
            return arrays;
        } else {
            System.out.println("File not found");
            return null;
        }
    }

    static int[] naiveMultiplyPolynomials(int[] A, int[] B) {
        int degreeA = A.length - 1;
        int degreeB = B.length - 1;
        int degreeResult = degreeA + degreeB;

        int[] result = new int[degreeResult + 1];

        for (int i = 0; i <= degreeA; i++) {
            for (int j = 0; j <= degreeB; j++) {
                result[i + j] += A[i] * B[j];
            }
        }

        return result;
    }
    static int[] multiplyPolynomials(int[] A, int[] B) {
        int n = A.length;
        if (n == 0) {
            return new int[0];
        }
        if (n == 1) {
            return new int[] {A[0] * B[0]};
        }

        int mid = n / 2;

        // Разделяем массивы на две части
        int[] A_low = Arrays.copyOfRange(A, 0, mid);
        int[] A_high = Arrays.copyOfRange(A, mid, n);
        int[] B_low = Arrays.copyOfRange(B, 0, mid);
        int[] B_high = Arrays.copyOfRange(B, mid, n);

        // Рекурсивно умножаем
        int[] P1 = multiplyPolynomials(A_low, B_low);
        int[] P2 = multiplyPolynomials(add(A_low, A_high), add(B_low, B_high));
        int[] P3 = multiplyPolynomials(A_high, B_high);

        // Вычисляем коэффициенты результирующего полинома
        int[] result = new int[2 * n - 1];

        // Добавляем P1 в начало результата
        for (int i = 0; i < P1.length; i++) {
            result[i] += P1[i];
        }

        // Добавляем P2 - P1 - P3 в середину результата
        int[] P2_minus_P1_minus_P3 = subtract(subtract(P2, P1), P3);
        for (int i = 0; i < P2_minus_P1_minus_P3.length; i++) {
            result[i + mid] += P2_minus_P1_minus_P3[i];
        }

        // Добавляем P3 в конец результата
        for (int i = 0; i < P3.length; i++) {
            result[i + 2 * mid] += P3[i];
        }

        return result;
    }

    static int[] add(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = A[i] + B[i];
        }
        return result;
    }

    static int[] subtract(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = A[i] - B[i];
        }
        return result;
    }
}
