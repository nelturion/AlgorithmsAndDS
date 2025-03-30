package com.asd.andreyuk.lab4;

import com.asd.andreyuk.Utils;

public class Task4 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        String s = utils.readStringFromFile("lab4/task4");
        System.out.println(checkBrackets(s));
        utils.writeStringToFile("lab4/task4", checkBrackets(s));
        utils.stopMeasuring();
    }

    private static String checkBrackets(String input) {
        MyStack<Character> stack = new MyStack<>();
        MyStack<Integer> positionStack = new MyStack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                positionStack.push(i+1);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return String.valueOf(i + 1);
                }

                char top = stack.pop();
                positionStack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return String.valueOf(i + 1);
                }
            }
        }

        if (stack.isEmpty()) {
            return "Success";
        } else {
            /*
            // Находим индекс незакрытой скобки
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if ((c == '(' || c == '[' || c == '{') ) {
                    return String.valueOf(i + 1);
                }
            }
            */
            return String.valueOf(positionStack.peek());
        }
        //return "Success"; // Этого никогда не произойдет, но нужно для компиляции
    }
}
