package com.asd.andreyuk.lab4;

import com.asd.andreyuk.Utils;

import java.io.InputStream;
import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        Object[] data = customRead();
        assert data != null;
        int n = (int) data[0]; // Количество новобранцев
        int m = (int) data[1]; // Количество команд
        String[] commands = (String[]) data[2];

        // Создаем строй и толпу
        Novobranets[] allNovobrantsy = new Novobranets[n + 1];
        for (int i = 1; i <= n; i++) {
            allNovobrantsy[i] = new Novobranets(i);
        }

        head = allNovobrantsy[1]; // Строй начинается с новобранца 1

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] parts = commands[i].split(" ");

            switch (parts[0]) {
                case "left":
                    int idToInsertLeft = Integer.parseInt(parts[1]);
                    int idBefore = Integer.parseInt(parts[2]);
                    insertLeft(allNovobrantsy[idToInsertLeft], allNovobrantsy[idBefore], allNovobrantsy);
                    break;
                case "right":
                    int idToInsertRight = Integer.parseInt(parts[1]);
                    int idAfter = Integer.parseInt(parts[2]);
                    insertRight(allNovobrantsy[idToInsertRight], allNovobrantsy[idAfter], allNovobrantsy);
                    break;
                case "leave":
                    int idToLeave = Integer.parseInt(parts[1]);
                    leave(allNovobrantsy[idToLeave], allNovobrantsy);
                    break;
                case "name":
                    int idToName = Integer.parseInt(parts[1]);
                    sb.append(nameNeighbors(allNovobrantsy[idToName])).append('\n');
                    break;
            }
        }

        utils.writeStringToFile("lab4/task12", sb.toString());
        utils.stopMeasuring();
    }

    private static Object[] customRead() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/lab4/task12/input.txt");
        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            String line = scanner.nextLine();
            int n = Integer.parseInt(line.split(" ")[0]);
            int m = Integer.parseInt(line.split(" ")[1]);
            String[] commands = new String[m];
            for (int i = 0; i < m; i++) {
                commands[i] = scanner.nextLine();
            }
            return new Object[]{n, m, commands};
        } else {
            System.out.println("Input file not found");
            return null;
        }
    }

    static class Novobranets {
        int id;
        Novobranets prev;
        Novobranets next;

        Novobranets(int id) {
            this.id = id;
            this.prev = null;
            this.next = null;
        }
    }

    private static Novobranets head; // Голова строя

    static void insertLeft(Novobranets toInsert, Novobranets before, Novobranets[] allNovobrantsy) {
        if (toInsert == before) return;

        // Удалить toInsert из текущего положения
        if (toInsert.prev != null) {
            toInsert.prev.next = toInsert.next;
        }
        if (toInsert.next != null) {
            toInsert.next.prev = toInsert.prev;
        }

        // Если toInsert был head, нужно обновить head
        if (head == toInsert) {
            head = toInsert.next;
        }

        // Вставить toInsert слева от before
        toInsert.next = before;
        toInsert.prev = before.prev;

        if (before.prev != null) {
            before.prev.next = toInsert;
        }
        before.prev = toInsert;

        // Если before был head, нужно обновить head
        if (before == head) {
            head = toInsert;
        }

        //Если вставляем в начало, обновим head
        if (toInsert.prev == null) {
            head = toInsert;
        }
    }

    static void insertRight(Novobranets toInsert, Novobranets after, Novobranets[] allNovobrantsy) {
        if (toInsert == after) return;

        // 1. Удалить toInsert из текущего положения
        if (toInsert.prev != null) {
            toInsert.prev.next = toInsert.next;
        }
        if (toInsert.next != null) {
            toInsert.next.prev = toInsert.prev;
        }
        // Если toInsert был head, нужно обновить head
        if (head == toInsert) {
            head = toInsert.next;
        }

        // 2. Вставить toInsert справа от after
        toInsert.prev = after;
        toInsert.next = after.next;

        if (after.next != null) {
            after.next.prev = toInsert;
        }
        after.next = toInsert;
    }

    static void leave(Novobranets toLeave, Novobranets[] allNovobrantsy) {
        if (toLeave.prev != null) {
            toLeave.prev.next = toLeave.next;
        }
        if (toLeave.next != null) {
            toLeave.next.prev = toLeave.prev;
        }

        // Если toLeave был head, нужно обновить head
        if (head == toLeave) {
            head = toLeave.next;
        }

        toLeave.next = null;
        toLeave.prev = null;
    }

    static String nameNeighbors(Novobranets novobranets) {
        int leftNeighbor = (novobranets.prev != null) ? novobranets.prev.id : 0;
        int rightNeighbor = (novobranets.next != null) ? novobranets.next.id : 0;
        return leftNeighbor + " " + rightNeighbor;
    }
}
