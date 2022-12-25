package org.example.solve;

public class countSpecialChar {
    public static void main(String[] args) {
        String str = "ABCDEFGHIJKLMONOWPQKWNQASABSJDBIUBIDWQJDK";
        System.out.println(new countSpecialChar().countCertainCharacter(str, 'A'));
        System.out.println(new countSpecialChar().countCertainCharacter02(str, 'A'));
    }

    public int countCertainCharacter(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) count++;
        }

        return count;
    }

    public long countCertainCharacter02(String str, char ch) {

        return str.chars()
                .filter(character -> character == ch)
                .count();
    }
}
