package by.pochepko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

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
//        try {
//            FileInputStream fis = new FileInputStream("src/main/resources/promocodes.properties");
//            Properties properties = new Properties();
//            int i = 0;
//            properties.load(fis);
//            while (properties.getProperty("promocode" + i) != null) {
//                promoCodes.add(new PromoCode(properties.getProperty("promocode" + i), Integer.parseInt(properties.getProperty("fixdiscount" + i)),
//                        Integer.parseInt(properties.getProperty("percentdiscount" + i))));
//                i++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File file = new File("src/main/resources/promocodes.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PromoCodesList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PromoCodesList promoCodesList;
            promoCodesList = ((PromoCodesList) unmarshaller.unmarshal(file));
            for (PromoCode promoCode : promoCodesList.getPromoCodes()) {
                System.out.println(promoCode);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
