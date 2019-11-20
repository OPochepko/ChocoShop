import java.util.ArrayList;

public class Basket {

    private ArrayList<OrderLine> order;

    private PromoCodes promoCode;

    class OrderLine {

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
