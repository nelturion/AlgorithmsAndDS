package com.asd.andreyuk.lab3;

import com.asd.andreyuk.Utils;

public class Task1 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int[] arrayForRandomized = utils.readIntArrayFromFile("lab3/task1");
        int[] arrayForThreeWay = utils.readIntArrayFromFile("lab3/task1");

        long startTime = System.nanoTime();
        Thread threeWayThread = new Thread(() -> {
            try {
                threeWayQuickSort(arrayForThreeWay, 0, arrayForThreeWay.length - 1);
                //System.out.println("Three way quick sort: " + ((float) (System.nanoTime() - startTime) / 1_000_000) + " ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread randomizedThread = new Thread(() -> {
            try {
                randomizedQuickSort(arrayForRandomized, 0, arrayForRandomized.length - 1);
                //System.out.println("Randomized quick sort: " + ((float) (System.nanoTime() - startTime) / 1_000_000) + " ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        threeWayThread.start();
        randomizedThread.start();

        try {
            threeWayThread.join();
            randomizedThread.join();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        utils.writeIntegersArrayToFile("lab3/task1", arrayForThreeWay);
        utils.stopMeasuring();
    }

    private static void randomizedQuickSort(int[] array, int left, int right) {
        if (left < right) {
            int k = left + (int) (Math.random() * (right - left + 1));
            Utils.swap(array, left, k);
            int pivotIndex = partition(array, left, right);
            randomizedQuickSort(array, left, pivotIndex - 1);
            randomizedQuickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int l, int r) {
        int x = array[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i] <= x) {
                j++;
                Utils.swap(array, j, i);
            }
        }
        Utils.swap(array, l, j);
        return j;
    }

    private static void threeWayQuickSort(int[] array, int left, int right) {
        if (left < right) {
            int[] pivotBounds = threeWayPartition(array, left, right);
            threeWayQuickSort(array, left, pivotBounds[0] - 1);
            threeWayQuickSort(array, pivotBounds[1] + 1, right);
        }
    }

    private static int[] threeWayPartition(int[] array, int left, int right) {
        int randomPivot = left + (int) (Math.random() * (right - left + 1));
        Utils.swap(array, randomPivot, right);
        int pivot = array[right];
        int lt = left; // less than (<) pivot
        int gt = right; // greater than (>) pivot
        int i = left; // current index

        while (i <= gt) {
            if (array[i] < pivot) {
                Utils.swap(array, i++, lt++);
            } else if (array[i] > pivot) {
                Utils.swap(array, i, gt--);
            } else {
                i++;
            }
        }
        return new int[]{lt, gt}; // границы равных элементов
    }


}

