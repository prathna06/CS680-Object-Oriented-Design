package edu.umb.CS680.HW15;
class PercentageDiscountStrategy implements DiscountStrategy {
    private double discountPercentage;

    public PercentageDiscountStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        double discountAmount = (discountPercentage / 100) * totalPrice;
        return totalPrice - discountAmount;
    }
}