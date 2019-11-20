public class TaxesCalculator {
    public static double calculateTaxes(double price){
        return price > 100 ? price * 1.12 : price + 12;
    }
}
