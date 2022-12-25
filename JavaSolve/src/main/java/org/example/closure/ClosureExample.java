package org.example.closure;

public class ClosureExample {
    private int number = 999;
    public static void main(String[] args) {
        final int number = 100;

        new ClosureExample().test1();
    }

    private void test1() {

        int number = 100;
        testClosure("Anonymous class", new Runnable() {
            @Override
            public void run() {
                System.out.println(ClosureExample.this.number);
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(this.number));
    }

    private static void testClosure(final String name, final Runnable runnable) {
        System.out.println("=================================");
        System.out.println(name + ": ");
        runnable.run();
        System.out.println("=================================");
    }
}
