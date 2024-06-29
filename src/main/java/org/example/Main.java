package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Node> nodes = new ArrayList<>();

        System.out.println("Enter the chain (use space to separate values):");
        String input = scanner.nextLine();
        String[] values = input.split(" ");

        if (isNumeric(values[0])) {
            for (String value : values) {
                if (value.length() > 2) {
                    System.out.println("The numeric chain allows only two-digit numbers.");
                    return;
                }
                nodes.add(new NumberNode(Integer.parseInt(value)));
            }
        } else {
            for (String value : values) {
                value = value.toLowerCase();
                if (value.length() == 1) {
                    nodes.add(new CharNode(value.charAt(0)));
                } else {
                    nodes.add(new CharNode(value));
                }
            }
        }

        ChainValidator validator = new ChainValidator();
        boolean isValid = validator.validate(nodes);

        if (isValid) {
            System.out.println("Valid Chain");
        } else {
            System.out.println("Not Valid Chain");
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
