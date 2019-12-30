package by.pochepko.main;

import by.pochepko.dao.ChocolateRepository;
import by.pochepko.dao.PromocodeRepository;
import by.pochepko.model.Basket;
import by.pochepko.model.OrderLine;
import by.pochepko.services.OrderCalculator;
import by.pochepko.springcfg.DBChocoShopConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.invoke.MethodHandles;

public class ChocoShopSpring {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBChocoShopConfiguration.class);

        //test run
        var promocodeRepository = context.getBean(PromocodeRepository.class);
        var chocolateRepository = context.getBean(ChocolateRepository.class);
        var orderCalculator = context.getBean(OrderCalculator.class);

        Basket basket = new Basket();
        chocolateRepository.findAll().forEach(r -> basket.put(new OrderLine(r, 50)));
        basket.setPromoCode("DECIMATION");
        logger.debug("Test basket: " + basket.toString());
        orderCalculator.calculateOrderPrice(basket);


    }
}
