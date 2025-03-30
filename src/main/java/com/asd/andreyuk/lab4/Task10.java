package com.asd.andreyuk.lab4;

import com.asd.andreyuk.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Task10 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        String[] data = utils.readStringArrayFromFile("lab4/task10");

        List<Customer> customersList = new ArrayList<>(data.length);
        for (String s : data) {
            int arrivalHour = Integer.parseInt(s.split(" ")[0]);
            int arrivalMinute = Integer.parseInt(s.split(" ")[1]);
            int impatience = Integer.parseInt(s.split(" ")[2]);
            customersList.add(new Customer(arrivalHour, arrivalMinute, impatience));
        }
        Customer[] customers = customersList.toArray(new Customer[0]);

        String res = simulateQueue(customers);

        utils.writeStringToFile("lab4/task10", res);
        utils.stopMeasuring();
    }

    private static class Customer {
        int arrivalTime;
        int impatience;

        public Customer(int arrivalHour, int arrivalMinute, int impatience) {
            this.arrivalTime = arrivalHour * 60 + arrivalMinute;
            this.impatience = impatience;
        }

    }

    private static String simulateQueue(Customer[] customers) {
        MyQueue<Integer> queue = new MyQueue<>();   // храним время, когда освобождается касса
        StringBuilder results = new StringBuilder();
        int currentTime = 0;

        for (Customer customer : customers) {
            while (!queue.isEmpty() && queue.peek() <= customer.arrivalTime) {
                queue.dequeue();
            }

            if (queue.size() > customer.impatience) {
                results.append(formatTime(customer.arrivalTime)).append("\n");
            } else {
                int startServiceTime = queue.isEmpty() ? customer.arrivalTime : Math.max(customer.arrivalTime, currentTime);
                int finishTime = startServiceTime + 10;
                queue.enqueue(finishTime);
                currentTime = finishTime;
                results.append(formatTime(finishTime)).append("\n");
            }
        }
        return results.toString();
    }

    private static String formatTime(int timeInMinutes) {
        int hours = timeInMinutes / 60;
        int minutes = timeInMinutes % 60;
        return String.format("%d %d", hours, minutes);
    }

}
