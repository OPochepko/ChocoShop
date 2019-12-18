package by.pochepko;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "promocode")
public class PromoCode {
    @XmlAttribute(name = "code")
    private String code;
    @XmlElement(name = "fixdiscount")
    private int fixDiscount;
    @XmlElement(name = "percentdiscount")
    private int percentDiscount;

    public PromoCode() {
    }

    public PromoCode(String code, int fixDiscount, int percentDiscount) {
        this.code = code;
        this.fixDiscount = fixDiscount;
        this.percentDiscount = percentDiscount;
    }


    public String getCode() {
        return code;
    }

    public int getFixDiscount() {
        return fixDiscount;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "name='" + code + '\'' +
                ", fixDiscount=" + fixDiscount +
                ", percentDiscount=" + percentDiscount + "%" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromoCode promoCode = (PromoCode) o;
        return fixDiscount == promoCode.fixDiscount &&
                percentDiscount == promoCode.percentDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fixDiscount, percentDiscount);
    }

}
