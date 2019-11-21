public class OrderCalculator {

    TaxesCalculator taxesCalculator = new TaxesCalculator();

    PromoCodeApplier promoCodeApplier = new PromoCodeApplier();

    public int calculateOrderPrice(Basket basket){
        int finalCost = 0;

        for (OrderLine orderLine : basket.getOrder()){
            finalCost+=taxesCalculator.calculateTaxes(orderLine.getFullPrice());
        }
        finalCost = promoCodeApplier.applyPromoCode(basket.getPromoCode(),finalCost);

        return finalCost;
    }
}
