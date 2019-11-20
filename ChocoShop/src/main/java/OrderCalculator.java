public class OrderCalculator {
    public static double calculateOrderPrice(Basket basket){
        double finalCost = 0;
        for (Basket.OrderLine orderLine : basket.getOrder()){
            finalCost+=TaxesCalculator.calculateTaxes(orderLine.getFullPrice());
        }
        finalCost = PromoCodeApplier.applyPromoCode(basket.getPromoCode(),finalCost);

        return finalCost;
    }
}
