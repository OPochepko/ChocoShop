
public class PromoCodeApplier {

    public static double applyPromoCode(PromoCodes code, double cost){

        double costWithPromo = cost * (100 - code.getPercentDiscount())/100 - code.getFixDiscount(); ;

        return costWithPromo;
    }
    }
