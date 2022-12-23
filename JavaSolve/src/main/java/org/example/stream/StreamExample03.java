package org.example.stream;

import java.util.stream.Collectors.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample03 {
    public static void main(String[] args) {

        System.out.println(
            Stream.of(1, 3, 3, 5, 5)
                    .filter(i -> i  > 2)
                    .map(i -> i * 2)
                    .map(i -> "#" + i)
                    .collect(toList())
        );

        System.out.println(
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i  > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );

        System.out.println(
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i  > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(" : "))
        );

        System.out.println(
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i  > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(" : ", "[ ", " ]"))
        );

        System.out.println(
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i  > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(" : ", "[ ", " ]"))
        );

        System.out.println(
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i  > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(toList())
        );

        final Integer Integer127= 127;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 127) // Integer.valueOf() 로 Boxing 하는데, 127까지는 캐싱하여 사용한다
                        .filter(i -> i == Integer127) // Integer == 의 경우 메모리의 위치를 비교하는데 캐싱때문에 true 값이 반환된다.
                        .findFirst()
        );

        final Integer Integer128= 128;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)// Integer.valueOf() 로 Boxing 하는데, 127까지는 캐싱하여 사용한다
                        .filter(i -> i == Integer128) // 127보다 큰 수 일때, 성립하지 않는다
                        .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128) // Integer.valueOf() 로 Boxing 하는데, 127까지는 캐싱하여 사용한다
                        .filter(i -> i.equals(Integer128)) // equals 사용 시 true
                        .findFirst()
        );

        final Integer Integer3 = 3;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i > Integer3)
                        .count()
        );
    }
}
