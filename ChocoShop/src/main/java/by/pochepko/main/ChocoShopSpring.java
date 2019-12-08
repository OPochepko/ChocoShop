package by.pochepko.main;

import by.pochepko.services.DBPromocodeApplier;
import by.pochepko.springcfg.DBChocoShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChocoShopSpring {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBChocoShopConfiguration.class);
        context.getBean(DBPromocodeApplier.class).readPromocodes();
    }
}
