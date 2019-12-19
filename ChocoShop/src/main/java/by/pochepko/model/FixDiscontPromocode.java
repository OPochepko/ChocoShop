package by.pochepko.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fd")
public class FixDiscontPromocode extends Promocode {

    @Column(name = "fixdiscount")
    private int fixDiscount;

    public FixDiscontPromocode() {
    }

    public int getFixDiscount() {
        return fixDiscount;
    }

    public void setFixDiscount(int fixDiscount) {
        this.fixDiscount = fixDiscount;
    }

    @Override
    public String toString() {
        return "FixDiscontPromocode{" +
                "fixDiscount=" + fixDiscount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FixDiscontPromocode)) return false;
        FixDiscontPromocode that = (FixDiscontPromocode) o;
        return fixDiscount == that.fixDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fixDiscount);
    }
}
