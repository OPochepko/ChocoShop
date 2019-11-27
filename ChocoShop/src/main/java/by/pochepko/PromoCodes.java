package by.pochepko;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PromoCodes {

    private Map<String, PromoCode> promoCodes = new HashMap<>();

    public void add(PromoCode promoCode) {
        promoCodes.put(promoCode.getName(), promoCode);
    }

    public PromoCode get(String name) {
        return promoCodes.get(name);
    }

    public void remove(PromoCode promoCode) {
        promoCodes.remove(promoCode.getName());
    }

}
