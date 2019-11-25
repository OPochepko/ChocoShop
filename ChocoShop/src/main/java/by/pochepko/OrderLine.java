package by.pochepko;

public class OrderLine {

    private Chocolate chocolate;
    private int quantity;

    public Chocolate getChocolate() {
        return chocolate;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    private int fullPrice;

    public OrderLine(Chocolate chocolate, int quantity) {
        this.chocolate = chocolate;
        this.quantity = quantity;
        this.fullPrice = chocolate.getPrice() * quantity;
    }
}
