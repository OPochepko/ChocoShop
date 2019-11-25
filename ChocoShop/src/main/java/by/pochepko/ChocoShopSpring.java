package by.pochepko;

import by.pochepko.services.OrderCalculator;
import by.pochepko.services.OrderCalculatorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChocoShopSpring {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ChocoShopConfiguration.class);

    }
}
