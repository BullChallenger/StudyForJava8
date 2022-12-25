package org.example.solve;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class findNonRepeatable {
    public static void main(String[] args) {
        String str = "ABCVDCDEPWERQ";
        System.out.println(new findNonRepeatable().firstNonRepeatableCharacter(str));
        System.out.println(new findNonRepeatable().firstNonRepeatableCharacter02(str));
    }

    public char firstNonRepeatableCharacter(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public String firstNonRepeatableCharacter02(String str) {
        Map<Integer, Long> chs = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
