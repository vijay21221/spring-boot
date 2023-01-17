package space.gavinklfong.demo.streamapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@DataJpaTest
@Slf4j
public class StreamAPIPractice {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;


    @Test
    @DisplayName("Exercise 1")
    public void exercise1() {
        List<Product> filterByPriceAndCategoryProducts = productRepo.findAll()
                .stream().filter(product -> product.getPrice() > 100)
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .collect(Collectors.toList());

        filterByPriceAndCategoryProducts.forEach(product -> log.info(product.toString()));
        assert filterByPriceAndCategoryProducts.size() == 5;
    }

    @Test
    @DisplayName("Exercise 1 using predicate chaining")
    public void exercise1a() {
        Predicate<Product> productPricePredicate = product -> product.getPrice() > 100;
        Predicate<Product> productCategoryPredicate = product -> product.getCategory().equalsIgnoreCase("Books");

        productRepo.findAll()
                .stream()
                .filter(product -> productPricePredicate.test(product))
                .filter(product -> productCategoryPredicate.test(product))
                .collect(Collectors.toList()).forEach(p -> log.info(p.toString()));

        productRepo.findAll()
                .stream()
                .filter(productCategoryPredicate)
                .filter(productPricePredicate)
                .forEach(p -> log.info(p.toString()));

        productRepo.findAll()
                .stream()
                .filter(productCategoryPredicate.and(productPricePredicate))
                .forEach(p -> log.info(p.toString()));

        productRepo.findAll()
                .stream()
                .filter(p -> productCategoryPredicate.and(productPricePredicate).test(p)).forEach(p -> log.info(p.toString()));

    }


    @Test
    @DisplayName("Exercise2")
    public void exercise2() {

        List<Order> orders = orderRepo.findAll()
                .stream().filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equalsIgnoreCase("Toys")))
                .collect(Collectors.toList());
        orders.forEach(o -> log.info(o.toString()));
        assert orders.size() > 0;
    }

    @Test
    @DisplayName("AnyMatch practice")
    public void excersice2a(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        boolean isEvenExists = numbers.stream().anyMatch(num -> num %2 == 0);
        log.info("Even number exists: " + isEvenExists);
        assert isEvenExists == true;
    }

    @Test
    @DisplayName("AnyMatch practice2")
    public void exercise2b() {
        List<String> stringList = Arrays.asList("vijay", "sai", "vamsi", "murali", "chaitanya", "srikanth");
        boolean endsWithA = stringList.stream().anyMatch(str -> str.endsWith("a"));
        assert endsWithA == true;
    }

    @Test
    @DisplayName("Any match practice 3")
    public void excercise2c() {
        List<String> stringList = Arrays.asList("vijay", "sai", "vamsi", "murali", "srikanth", "chaitanya");
        boolean isAnyStringLengthIs5 = stringList.stream().anyMatch(str -> str.length() == 5);
        assert isAnyStringLengthIs5 == true;

    }

    @Test
    @DisplayName("Exercise 3")
    public void exercise3() {
        Function<Product, Product> productFunction = (product) -> {
            product.setPrice(product.getPrice() * 0.10);
            return product;
        };
        productRepo.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .map(productFunction)
                .forEach(p -> log.info(p.toString()));
    }

    @Test
    @DisplayName("Exercise 4")
    public void exercise4() {
        long startTime = System.currentTimeMillis();
        Predicate<Order> datePredicate = order -> order.getOrderDate().compareTo(LocalDate.of(2021, 02, 01)) >= 0 &&
                order.getOrderDate().compareTo(LocalDate.of(2021, 04, 01)) <= 0 ;

        List<Product> products = customerRepo.findAll()
                .stream()
                .filter(c -> c.getTier().equals(2))
                .flatMap(c -> orderRepo.findAllByCustomer(c).stream().filter(datePredicate))
                .flatMap(order -> order.getProducts().stream())
                .distinct().collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 4 - execution time: %1$d ms", (endTime - startTime)));
        products.forEach(o -> log.info(o.toString()));
        assert products.size() == 19;
    }

    @Test
    @DisplayName("Exercise 4a")
    public void exercise4a() {
        long startTime = System.currentTimeMillis();
        List<Product> products = orderRepo.findAll()
                .stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 02, 01)) >= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 04, 01)) <=0)
                .flatMap(order -> order.getProducts().stream())
                .distinct().collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 4a - execution time: %1$d ms", (endTime - startTime)));
        assert products.size() == 19;
    }

    @Test
    @DisplayName("Exercise 5 cheapest product")
    public void exercise5() {

        Optional<Product> cheapestProduct = productRepo.findAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .min(Comparator.comparing(Product::getPrice));

        cheapestProduct.ifPresent(System.out::println);
    }

    @Test
    @DisplayName("Exercise 5a cheapest product using sorted")
    public void exercise5a() {
        Optional<Product> cheapestProduct =
                productRepo
                        .findAll()
                        .stream()
                        .sorted(Comparator.comparing(Product::getPrice))
                        .findFirst();

        assert cheapestProduct.isPresent();

    }

    @Test
    @DisplayName("Exercise 5b find 3 cheapest products")
    public void exercise5b() {
        productRepo
                .findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Get  3 most recent placed orders")
    public void exercise6() {
        orderRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3).forEach(System.out::println);
    }

    @Test
    @DisplayName("log List of orders ordered on 15th march 2021 and return its products list")
    public void exercise7() {
        List<Product> result = orderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 03, 15)))
                .peek(order -> log.info(order.toString()))
                .flatMap(order -> order.getProducts().stream())
                .distinct().collect(Collectors.toList());

        result.forEach(p -> log.info(p.toString()));

    }

    @Test
    @DisplayName("Calculate the lump sum of product total price ordered on 14 Mar 2021")
    public void exercise8() {
       double totalAmount = orderRepo.findAll().stream()
               .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 02, 01)) >= 0)
               .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 03, 01)) < 0)
               .flatMap(order -> order.getProducts().stream())
               .mapToDouble(Product::getPrice)
               .sum();
       assert totalAmount == 11995.36;
       log.info("Total lump sum amount:" + totalAmount);
    }

    @Test
    @DisplayName("Average products on 15 th March 2021")
    public void exercise9 (){
        OptionalDouble average =orderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 03, 15)))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average();
        if(average.isPresent()){
            log.info("Average products: " + average.getAsDouble());
        }

    }

    @Test
    @DisplayName("statics")
    public void exercise10() {
        var summary = productRepo.findAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();

        System.out.println(summary);
    }

    @Test
    @DisplayName("Map of order and order product count")
    public void exercise11() {
        Map<Object, Object> orderIdCount =
                orderRepo.findAll()
                        .stream()
                        .collect(
                                Collectors.toMap(Order::getId, order -> order.getProducts().size()));

        orderIdCount.forEach((k,v) -> System.out.println(k +" : " + v));
    }

    @Test
    @DisplayName("Grouped by customer and orders")
    public void exercise12() {
        var collect = orderRepo
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        collect.forEach((k,v) -> System.out.println(k +" : " + v));
    }

    @Test
    @DisplayName("")
    public void exercise13(){
        var test = orderRepo
                .findAll()
                .stream()
                .collect(Collectors.toMap(Function.identity(), order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()));
                        test.forEach((k,v) -> System.out.println(k +" : " + v));
    }

    @Test
    @DisplayName("Data map with list of product name by category")
    public void exercise14() {
        Map<String, List<String>> dataMap = productRepo.findAll().stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())));
        dataMap.forEach((k,v)-> System.out.println(k +" : " + v));
    }

    @Test
    @DisplayName("Most expensive product by category")
    public void exercise15() {
        Map<String, Optional<Product>> categoryAndProductMap = productRepo.findAll().stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        categoryAndProductMap.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
