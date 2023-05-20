package edu.umb.CS680.HW15;

class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotalPrice(double totalPrice) {
        if (discountStrategy == null) {
            return totalPrice;
        }
        return discountStrategy.applyDiscount(totalPrice);
    }
}