package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) {

        final Product productA = new Product(1L, "A", new BigInteger("10000"));
        final Product productB = new Product(2L, "B", new BigInteger("20000"));
        final Product productC = new Product(3L, "C", new BigInteger("30000"));
        final Product productD = new Product(4L, "D", new BigInteger("40000"));
        final Product productE = new Product(5L, "E", new BigInteger("50000"));

        final List<Product> products = Arrays.asList(
                productA,
                productB,
                productC,
                productD,
                productE
        );

        final BigInteger basePrice = new BigInteger("25000");

        final List<Product> result = filter(products, product -> product.getPrice().compareTo(basePrice) >= 0);
        final List<Product> result2 = filter(products, product -> product.getPrice().compareTo(basePrice) <= 0);

        System.out.println(result);
        System.out.println("=============");
        System.out.println(result2);


        final List<Product> expensiveProducts = filter(products, product -> product.getPrice().compareTo(basePrice) >= 0);

        final List<DiscountedProduct> discountedProducts = map(expensiveProducts, product -> new DiscountedProduct(product.getId(),
                product.getName(), product.getPrice().subtract(new BigInteger("10000"))));

        System.out.println("expensiveProducts : " + expensiveProducts);
        System.out.println("=============");
        System.out.println("discountedProducts : " + discountedProducts);

        final BigInteger total = total(products, product -> product.getPrice());
        System.out.println("=============");
        System.out.println("Total Price of All Products : " + total);

        Order order = new Order(1L, "on-1234", Arrays.asList(
            new OrderedItem(1L, productA, 2),
            new OrderedItem(2L, productC, 1),
            new OrderedItem(3L, productD, 10)
        ));

        System.out.println("order total : " + order.totalPrice());
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }

        return result;
    }

    private static <T> BigInteger total(List<T> list, Function<T, BigInteger> mapper) {
        BigInteger total = BigInteger.ZERO;
        for (final T t : list) {
            total = total.add(mapper.apply(t));
        }

        return total;
    }

    @Data
    @AllArgsConstructor
    static class Product {
        private Long id;
        private String name;
        private BigInteger price;
    }

    @ToString(callSuper = true)
    static class DiscountedProduct extends Product {
        public DiscountedProduct(Long id, String name, BigInteger price) {
            super(id, name, price);
        }
    }

    @AllArgsConstructor
    @Data
    static class OrderedItem {
        private Long id;
        private Product product;
        private int quantity;

        public BigInteger getItemTotal() {
            return product.getPrice().multiply(BigInteger.valueOf(quantity));
        }
    }

    @AllArgsConstructor
    @Data
    static class Order {
        private Long id;
        private String orderNumber;
        private List<OrderedItem> orderedItems;

        public BigInteger totalPrice() {
            return total(orderedItems, orderedItem -> orderedItem.getItemTotal());
        }
    }
}