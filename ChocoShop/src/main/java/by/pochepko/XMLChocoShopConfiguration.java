package by.pochepko;

import by.pochepko.services.PromoCodeApplier;
import by.pochepko.services.XMLPromocodeApplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "by.pochepko")
@Configuration
public class XMLChocoShopConfiguration {

    @Bean
    public PromoCodeApplier promoCodeApplier() {
        PromoCodeApplier promoCodeApplier = new XMLPromocodeApplier();
        promoCodeApplier.readPromocodes();
        return promoCodeApplier;
    }


}

