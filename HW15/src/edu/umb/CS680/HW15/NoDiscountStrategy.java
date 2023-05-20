package edu.umb.CS680.HW15;

class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice;
    }
}