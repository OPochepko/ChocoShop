package by.pochepko;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    public List<OrderLine> getOrder() {
        return order;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    private List<OrderLine> order = new ArrayList<>();

    private String promoCode;

    public void put(OrderLine orderLine) {
        order.add(orderLine);
    }

    public void remove(OrderLine orderLine) {
        order.remove(orderLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equal(order, basket.order) &&
                promoCode == basket.promoCode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(order, promoCode);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "order=" + order +
                ", promoCode='" + promoCode + '\'' +
                '}';
    }
}
