package by.pochepko;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "promocodes")
@XmlRootElement(name = "promocode")
public class PromoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Basic
    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    @Basic
    public int getFixDiscount() {
        return fixDiscount;
    }

    private void setFixDiscount(int fixDiscount) {
        this.fixDiscount = fixDiscount;
    }

    @Basic
    public int getPercentDiscount() {
        return percentDiscount;
    }

    private void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
