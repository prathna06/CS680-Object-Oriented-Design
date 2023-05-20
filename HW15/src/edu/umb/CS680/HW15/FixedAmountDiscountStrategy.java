package edu.umb.CS680.HW15;

class FixedAmountDiscountStrategy implements DiscountStrategy {
    private double discountAmount;

    public FixedAmountDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        if (totalPrice >= discountAmount) {
            return totalPrice - discountAmount;
        }
        return totalPrice;
    }
}