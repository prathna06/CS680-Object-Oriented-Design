package edu.umb.CS680.HW15;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ShoppingCartTest {

    /* public static void main(String[] args) {
        testPercentageDiscountStrategy();
        testFixedAmountDiscountStrategy();
        testNoDiscountStrategy();
    } */
    @Test
    public  void testPercentageDiscountStrategy() {
        // Create a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Create some items
        Item item1 = new Item("Item 1", 10.0);
        Item item2 = new Item("Item 2", 20.0);
        Item item3 = new Item("Item 3", 15.0);

        // Add items to the cart
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);

        // Calculate the total price without any discount
        double totalPrice = calculateTotalPrice(cartItems);
        System.out.println("Total price without discount: $" + totalPrice);

        // Set the discount strategy to "Percentage Discount" (20% off)
        shoppingCart.setDiscountStrategy(new PercentageDiscountStrategy(20));
        double discountedPrice = shoppingCart.calculateTotalPrice(totalPrice);
        assertEquals(36, discountedPrice);
        System.out.println("Total price with percentage discount: $" + discountedPrice);
    }
    @Test
    public  void testFixedAmountDiscountStrategy() {
        // Create a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Create some items
        Item item1 = new Item("Item 1", 10.0);
        Item item2 = new Item("Item 2", 20.0);
        Item item3 = new Item("Item 3", 15.0);

        // Add items to the cart
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);

        // Calculate the total price without any discount
        double totalPrice = calculateTotalPrice(cartItems);
        assertEquals(45, totalPrice);
        System.out.println("Total price without discount: $" + totalPrice);

        // Set the discount strategy to "Fixed Amount Discount" ($5 off)
        shoppingCart.setDiscountStrategy(new FixedAmountDiscountStrategy(5));
        double discountedPrice = shoppingCart.calculateTotalPrice(totalPrice);
        System.out.println("Total price with fixed amount discount: $" + discountedPrice);
    }
    @Test
    public  void testNoDiscountStrategy() {
        // Create a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Create some items
        Item item1 = new Item("Item 1", 10.0);
        Item item2 = new Item("Item 2", 20.0);
        Item item3 = new Item("Item 3", 15.0);

        // Add items to the cart
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);

        // Calculate the total price without any discount
        double totalPrice = calculateTotalPrice(cartItems);
        System.out.println("Total price without discount: $" + totalPrice);

        // Set the discount strategy to "No Discount"
        shoppingCart.setDiscountStrategy(new NoDiscountStrategy());
        double discountedPrice = shoppingCart.calculateTotalPrice(totalPrice);
        assertEquals(45, discountedPrice);
        System.out.println("Total price with no discount: $" + discountedPrice);
    }

    private static double calculateTotalPrice(List<Item> items) {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}