package org.example.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sensitiveFieldEncrypted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String s = sc.next();

        System.out.println(solution(s, k));
    }

    public static String solution(String s, int k) {
        List<String> commands = new ArrayList<>();

        boolean isOpen = false;

        StringBuilder command = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '"') {
                isOpen = !isOpen;
            }

            if (c != '_' || isOpen) {
                command.append(c);
            } else if (command.length() > 0) {
                commands.add(command.toString());
                command = new StringBuilder();
            }
        }

        if (k >= commands.size()) {
            return "ERROR";
        } else {
            commands.set(k, "******");
            return String.join("_", commands);
        }
    }
}
