package org.example.stream;

import java.util.stream.IntStream;

public class StreamExample01 {

    public static void main(String[] args) {
        System.out.println("Range");
        IntStream.range(1, 11).forEach(i -> System.out.print(i + " "));
        System.out.println("\nRangeClosed");
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));
    }
}
