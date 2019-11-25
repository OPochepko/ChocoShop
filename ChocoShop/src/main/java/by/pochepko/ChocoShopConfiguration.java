package by.pochepko;

import by.pochepko.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ChocoShopConfiguration {

    @Bean
    public TaxesCalculator taxesCalculator(){
        return new TaxesCalculatorImpl();
    }

    @Bean
    public PromoCodeApplier promoCodeApplier(){
        return  new PromoCodeApplierImpl();
    }

    @Bean
    public OrderCalculator orderCalculator(){
        return  new OrderCalculatorImpl(taxesCalculator(),promoCodeApplier());
    }


}

