public class TaxesCalculator {
    public static int calculateTaxes(int price){
        return price > 100 ? (int) (price * 1.12) : price + 12;
    }
}
