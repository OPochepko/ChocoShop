package by.pochepko.model;

import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chocolate")
public class Chocolate {
    @Id
    @GeneratedValue
    private int id;

    private int price;

    private String name;

    public Chocolate(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Chocolate() {

    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
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
