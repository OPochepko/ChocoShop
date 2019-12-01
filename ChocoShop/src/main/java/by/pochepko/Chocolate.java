package by.pochepko;

import com.google.common.base.Objects;

public class Chocolate {

    private int price;

    private String name;

    public Chocolate(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chocolate chocolate = (Chocolate) o;
        return price == chocolate.price &&
                Objects.equal(name, chocolate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, name);
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
