package by.pochepko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ChocoShopSpring {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ChocoShopConfiguration.class);
        PromoCodes promoCodes = context.getBean(PromoCodes.class);
//        try {
//            Scanner scanner = new Scanner(context.getResource("classpath:promocodes.properties").getFile());
//            while (scanner.hasNext()) {
//
//                promoCodes.add(new PromoCode(scanner.next(), scanner.nextInt(), scanner.nextInt()));
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/promocodes.properties");
            Properties properties = new Properties();
            int i = 0;
            properties.load(fis);
            while (properties.getProperty("promocode" + i) != null) {
                promoCodes.add(new PromoCode(properties.getProperty("promocode" + i), Integer.parseInt(properties.getProperty("fixdiscount" + i)),
                        Integer.parseInt(properties.getProperty("percentdiscount" + i))));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
