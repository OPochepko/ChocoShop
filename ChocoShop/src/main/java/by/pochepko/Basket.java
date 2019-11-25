package by.pochepko;

import java.util.ArrayList;

public class Basket {

    private ArrayList<OrderLine> order = new ArrayList<>();

    private PromoCodes promoCode;


    public void put(OrderLine orderLine){
        order.add(orderLine);
    }

    public void remove(int index){
        order.remove(index);
    }

    public void setPromoCode(PromoCodes promoCode) {
        this.promoCode = promoCode;
    }

    public ArrayList<OrderLine> getOrder() {
        return order;
    }

    public PromoCodes getPromoCode() {
        return promoCode;
    }
}
