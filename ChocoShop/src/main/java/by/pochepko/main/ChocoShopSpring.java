package by.pochepko.main;

import by.pochepko.services.SpringDataDBService;
import by.pochepko.springcfg.DBChocoShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChocoShopSpring {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBChocoShopConfiguration.class);
        SpringDataDBService dbService = context.getBean(SpringDataDBService.class);
        dbService.readPromocodes();
        dbService.readChocolates();

    }
}
