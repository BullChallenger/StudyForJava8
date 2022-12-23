package org.example;

import java.text.Collator;
import java.time.temporal.ChronoField;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String str = "aaabbbwewecccc22d";

//        Map<Character, Long> counts = countChars(str);
//        System.out.println(counts.toString());

        String result = findChar(str);
        System.out.println(result);
    }

    private static Map<Character, Long> countChars(String str) {

        return str.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    private static String findChar(String str) {
        Map<Integer, Long> chs = str.codePoints()
                .boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        Collectors.counting()));

        int cp = chs.entrySet().stream().filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        return String.valueOf(Character.toChars(cp));
    }
}