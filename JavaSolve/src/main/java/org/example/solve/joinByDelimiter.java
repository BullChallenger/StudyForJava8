package org.example.solve;

import java.util.Arrays;
import java.util.stream.Collectors;

public class joinByDelimiter {
    public static void main(String[] args) {
        System.out.println(new joinByDelimiter().joinByDelimiter00(':', "How", "Old", "Are", "U", "?"));
        System.out.println(new joinByDelimiter().joinByDelimiter01(':', "How", "Old", "Are", "U", "?"));
    }

    public String joinByDelimiter00(char delimiter, String... args) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            sb.append(args[i]).append(delimiter);
        }
        sb.append(args[i]);

        return sb.toString();
    }

    public String joinByDelimiter01(char delimiter, String... args) {
        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }
}
