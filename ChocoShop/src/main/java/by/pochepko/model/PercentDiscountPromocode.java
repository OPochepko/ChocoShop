package by.pochepko.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pd")
public class PercentDiscountPromocode extends Promocode {
    @Column(name = "percentdiscount")
    private int percentDiscount;

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public String toString() {
        return "PercentDiscountPromocode{" +
                "percentDiscount=" + percentDiscount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PercentDiscountPromocode)) return false;
        PercentDiscountPromocode that = (PercentDiscountPromocode) o;
        return percentDiscount == that.percentDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(percentDiscount);
    }
}
