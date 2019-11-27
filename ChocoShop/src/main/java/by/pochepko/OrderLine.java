package by.pochepko;

import com.google.common.base.Objects;

public class OrderLine {

    private Chocolate chocolate;
    private int quantity;


    public OrderLine(Chocolate chocolate, int quantity) {
        this.chocolate = chocolate;
        this.quantity = quantity;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return quantity * chocolate.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return quantity == orderLine.quantity &&
                Objects.equal(chocolate, orderLine.chocolate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chocolate, quantity);
    }

}
