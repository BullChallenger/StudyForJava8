package org.example.solve;

import lombok.AllArgsConstructor;
import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class countChar {
    public static void main(String[] args) {
        String str = "AVCSCFMDIWENR";

        System.out.println(new countChar().countCharacters(str));
        System.out.println(new countChar().countCharacters2(str));
        }

    public Map<Character, Integer> countCharacters(String str) {

        Map<Character, Integer> result = new HashMap<>();

        for (char ch : str.toCharArray()) {
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    public Map<Character, Long> countCharacters2(String str) {
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }
}


