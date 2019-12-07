package by.pochepko;

import by.pochepko.services.DBPromocodeApplier;
import by.pochepko.services.PromoCodeApplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "by.pochepko")
@Configuration


public class DBChocoShopConfiguration {

    @Bean
    public PromoCodeApplier promoCodeApplier() {
        PromoCodeApplier promoCodeApplier = new DBPromocodeApplier();
        promoCodeApplier.readPromocodes();
        return promoCodeApplier;
    }
}
