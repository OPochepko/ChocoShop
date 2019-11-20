
public class PromoCodeApplier {

    public static int applyPromoCode(PromoCodes code, int cost){

        int costWithPromo = cost * (100 - code.getPercentDiscount())/100 - code.getFixDiscount(); ;

        return costWithPromo;
    }
    }
