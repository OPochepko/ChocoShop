package by.pochepko;

import com.google.common.base.Objects;

public class PromoCode {

    private String name;
    private int fixDiscount;
    private int percentDiscount;

    public PromoCode(String name, int fixDiscount, int percentDiscount) {
        this.name = name;
        this.fixDiscount = fixDiscount;
        this.percentDiscount = percentDiscount;
        System.out.println("Created" + this.toString());
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "name='" + name + '\'' +
                ", fixDiscount=" + fixDiscount +
                ", percentDiscount=" + percentDiscount + "%" +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getFixDiscount() {
        return fixDiscount;
    }

    public int getPercentDiscount() {
        return percentDiscount;
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
