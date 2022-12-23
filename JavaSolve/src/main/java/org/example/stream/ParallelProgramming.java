package org.example.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParallelProgramming {
    public static void main(String[] args) {
        final int[] sum = { 0 };

        IntStream.range(0, 100)
                .forEach(i -> sum[0] += i);

        System.out.println("sum : " + sum[0]);

        final int[] sum2 = { 0 };
        // Parallel Programming
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> sum2[0] += i);

        System.out.println("parallel sum with side-effect : " + sum2[0]);

        // Parallel Programming
        System.out.println("parallel Stream.sum() no side-effect : " +
                IntStream.range(0, 100)
                        .parallel()
                        .sum());

        System.out.println("Parallel Programming ==================");
        final long start = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Non-Parallel Programming ==================");
        final long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .stream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start2);
    }
}
