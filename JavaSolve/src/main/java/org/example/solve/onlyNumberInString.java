package org.example.solve;

public class onlyNumberInString {
    public static void main(String[] args) {
        String str = "!@ACWNEWEQEL2";
        String str2 = "000122131300445";

        System.out.println(new onlyNumberInString().containsOnlyDigits(str));
        System.out.println(new onlyNumberInString().containsOnlyDigits02(str2));
        System.out.println(new onlyNumberInString().containsOnlyDigits03(str));
    }

    public boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean containsOnlyDigits02(String str) {
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }

    public boolean containsOnlyDigits03(String str) {
        return str.matches("[0-9]+");
    }
}
