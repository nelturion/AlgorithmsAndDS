package com.asd.andreyuk.lab4;

import com.asd.andreyuk.Utils;

import java.io.InputStream;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        MyQueue<Integer> queue = new MyQueue<>();
        String[] commands = queueReader();
        assert commands != null;

        StringBuilder output = new StringBuilder();
        for (String command : commands) {
            if (command.split(" ")[0].equals("-")) {
                output.append(queue.dequeue());
                output.append("\n");
            } else if (command.split(" ")[0].equals("+")) {
                queue.enqueue(Integer.parseInt(command.split(" ")[1]));
            }
        }

        utils.writeStringToFile("lab4/task2", output.toString());
        utils.stopMeasuring();
    }

    private static String[] queueReader() {
        ClassLoader classLoader = Task2.class.getClassLoader();
        InputStream stream = classLoader.getResourceAsStream("txt/lab4/task2/input.txt");

        if (stream != null) {
            Scanner scanner = new Scanner(stream);
            String[] strings = new String[Integer.parseInt(scanner.nextLine())];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = scanner.nextLine();
            }

            return strings;
        } else {
            System.out.println("File not found");
            return null;
        }
    }
}
