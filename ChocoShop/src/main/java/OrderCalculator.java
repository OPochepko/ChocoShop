public class OrderCalculator {
    public int calculateOrderPrice(Basket basket){
        int finalCost = 0;

        TaxesCalculator taxesCalculator = new TaxesCalculator();

        PromoCodeApplier promoCodeApplier = new PromoCodeApplier();

        for (OrderLine orderLine : basket.getOrder()){
            finalCost+=taxesCalculator.calculateTaxes(orderLine.getFullPrice());
        }
        finalCost = promoCodeApplier.applyPromoCode(basket.getPromoCode(),finalCost);

        return finalCost;
    }
}
