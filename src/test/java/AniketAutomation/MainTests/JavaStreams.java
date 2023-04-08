package AniketAutomation.MainTests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {

	private static List <product1> productsList = new ArrayList < product1 > ();

    public static void main(String[] args) {

        // Adding Products
        productsList.add(new product1(1, "HP Laptop", 25000f));
        productsList.add(new product1(2, "Dell Laptop", 30000f));
        productsList.add(new product1(3, "Lenevo Laptop", 28000f));
        productsList.add(new product1(4, "Sony Laptop", 28000f));
        productsList.add(new product1(5, "Apple Laptop", 90000f));
        // With Java 8 Stream API'S
        FilterwithStreamAPI();
        IteratewithStream();
        SumWithStream();
        MinMax();
    }

    private static void FilterwithStreamAPI() {
        // filtering data of list
        List < Float > productPriceList = productsList.stream().filter((product) -> product.getPrice() > 25000)
            .map((product) -> product.getPrice()).collect(Collectors.toList());
        // displaying data
        productPriceList.forEach((price) -> System.out.println(price));
    }
    private static void  IteratewithStream() {
    	productsList.stream().filter(product -> product.getPrice() == 30000)
        .forEach(product -> System.out.println(product.getName()+"-"+product.getPrice()));
    }
    //Sum of all products
    private static void  SumWithStream() {
    	double totalPrice3 = productsList.stream()
                .collect(Collectors.summingDouble(product -> product.getPrice()));
            System.out.println(totalPrice3);
    }
    //Find Max and Min Product Price
    private static void  MinMax() { 
 // max() method to get max Product price
    product1 productA = productsList.stream()
        .max((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1).get();

    System.out.println(productA.getPrice());
    // min() method to get min Product price
    product1 productB = productsList.stream()
        .max((product1, product2) -> product1.getPrice() < product2.getPrice() ? 1 : -1).get();
    System.out.println(productB.getPrice());

    }}

