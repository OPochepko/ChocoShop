public class TaxesCalculator {
    public int calculateTaxes(int price){
        return price > 100 ? (int) (price * 1.12) : price + 12;
    }
}
