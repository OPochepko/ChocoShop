public class OrderCalculator {

    private TaxesCalculator taxesCalculator;

    private PromoCodeApplier promoCodeApplier;

    public OrderCalculator(TaxesCalculator taxesCalculator, PromoCodeApplier promoCodeApplier) {
        this.taxesCalculator = taxesCalculator;
        this.promoCodeApplier = promoCodeApplier;
    }

    public int calculateOrderPrice(Basket basket){
        int finalCost = 0;

        for (OrderLine orderLine : basket.getOrder()){
            finalCost+=taxesCalculator.calculateTaxes(orderLine.getFullPrice());
        }
        finalCost = promoCodeApplier.applyPromoCode(basket.getPromoCode(),finalCost);

        return finalCost;
    }
}
