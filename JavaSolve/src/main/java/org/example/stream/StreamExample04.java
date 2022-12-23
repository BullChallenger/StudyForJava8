package org.example.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.FunctionalInterfaceExamples;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class StreamExample04 {
    public static void main(String[] args) {
        final List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigInteger("100000")),
                new Product(2L, "B", new BigInteger("200000")),
                new Product(3L, "C", new BigInteger("300000")),
                new Product(4L, "D", new BigInteger("400000")),
                new Product(5L, "E", new BigInteger("500000"))
        );


        System.out.println("가격이 300000원 이상인 제품" +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigInteger("300000")) >= 0)
                    .collect(toList())
        );

        System.out.println("가격이 300000원 이상인 제품" + "\n" +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigInteger("300000")) >= 0)
                    .map(String::valueOf)
                    .collect(joining("\n"))
        );

        System.out.println("모든 제품 가격의 합 : " +
                products.stream()
                        .map(product -> product.getPrice())
                        .reduce(BigInteger.ZERO, (price1, price2) -> price1.add(price2))
        );

        System.out.println("가격이 300000원 이상인 제품 가격의 합 : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigInteger("300000")) >= 0)
                        .map(product -> product.getPrice())
                        .reduce(BigInteger.ZERO, (price1, price2) -> price1.add(price2))
        );

        System.out.println("가격이 300000원 이상인 제품의 수 : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigInteger("300000")) >= 0)
                        .count());

        final OrderedItem itemA = new OrderedItem(1L, products.get(0), 1);
        final OrderedItem itemB = new OrderedItem(2L, products.get(2), 3);
        final OrderedItem itemC = new OrderedItem(3L, products.get(4), 10);

        final Order order = new Order(1L, Arrays.asList(itemA, itemB, itemC));

        System.out.println("주문 가격 합산 : " + order.getTotalPriceInOrder());
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigInteger price;
}

@AllArgsConstructor
@Data
class OrderedItem {
    private Long id;
    private Product product;
    private int quantity;

    public BigInteger getTotalPrice() {
        return product.getPrice().multiply(BigInteger.valueOf(quantity));
    }
}

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderedItem> orderedItems;

    public BigInteger getTotalPriceInOrder() {
        return orderedItems.stream()
                .map(orderedItem -> orderedItem.getTotalPrice())
                .reduce(BigInteger.ZERO, (price1, price2) -> price1.add(price2));
    }
}
