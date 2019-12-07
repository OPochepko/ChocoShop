package by.pochepko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChocoShopSpring {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBChocoShopConfiguration.class);
    }
}
