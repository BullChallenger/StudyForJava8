package org.example.closure;

public class ClosureExample {
    public static void main(String[] args) {
        final int number = 100;

        testClosure("Anonymous class", new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(number));
    }

    private static void testClosure(final String name, final Runnable runnable) {
        System.out.println("=================================");
        System.out.println(name + ": ");
        runnable.run();
        System.out.println("=================================");
    }
}
