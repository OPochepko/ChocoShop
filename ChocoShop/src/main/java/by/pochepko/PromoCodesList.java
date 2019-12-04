package by.pochepko;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "promocodes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PromoCodesList {

    @XmlElement(name = "promocode")
    private List<PromoCode> promoCodes = null;

    public List<PromoCode> getPromoCodes() {
        return promoCodes;
    }

    public void setPromoCodes(List<PromoCode> promoCodes) {
        this.promoCodes = promoCodes;
    }
}
