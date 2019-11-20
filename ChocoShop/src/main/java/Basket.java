import java.util.ArrayList;

public class Basket {

    private ArrayList<OrderLine> order;

    private PromoCodes promoCode;


    public void put(Chocolate chocolate, int quantity){
        order.add(new OrderLine(chocolate, quantity));
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
