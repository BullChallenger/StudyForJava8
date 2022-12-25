package org.example.solve;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class reverseWord {
    private static final String WHITESPACE = " ";

    public static void main(String[] args) {
        String str = "THIS IS FUCKING MIRACLE!";
        System.out.println(new reverseWord().reversing(str));
        System.out.println(new reverseWord().reversing02(str));
        System.out.println(new reverseWord().completelyReversing(str));
    }

    public String reversing(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }

            reversedString.append(reverseWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    private static final Pattern PATTERN = Pattern.compile(" +");

    public String reversing02(String str) {
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    public String completelyReversing(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
