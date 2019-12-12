package by.pochepko.services;

import by.pochepko.model.PromoCode;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XMLPromocodeApplier implements PromoCodeApplier {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Map<String, PromoCode> promocodes = new HashMap<>();

    @Override
    public int applyPromoCode(String code, int cost) {

        Validate.inclusiveBetween(0, Integer.MAX_VALUE, cost, "Cost must be not negative: %d", cost);

        PromoCode promoCode = promocodes.get(code);

        if (promoCode == null) {
            logger.info("promocode = NULL");
            return cost;
        } else {
            int costWithPromo = cost * (100 - promoCode.getPercentDiscount()) / 100 - promoCode.getFixDiscount();
            logger.info("promocode =" + promoCode);
            return costWithPromo;
        }
    }

    @Override
    public void readPromocodes() {
        readPromocodes("src/main/resources/promocodes.xml");
    }


    public void readPromocodes(String path) {
        File file = new File(path);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PromoCodesList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PromoCodesList promoCodesList;
            promoCodesList = ((PromoCodesList) unmarshaller.unmarshal(file));
            for (PromoCode promoCode : promoCodesList.getPromoCodes()) {
                promocodes.put(promoCode.getCode(), promoCode);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}

@XmlRootElement(name = "promocodes")
@XmlAccessorType(XmlAccessType.FIELD)
class PromoCodesList {

    @XmlElement(name = "promocode")
    private List<PromoCode> promoCodes = null;

    public List<PromoCode> getPromoCodes() {
        return promoCodes;
    }

    public void setPromoCodes(List<PromoCode> promoCodes) {
        this.promoCodes = promoCodes;
    }
}

