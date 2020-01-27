package by.pochepko.model;

import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "chocolate")
public class Chocolate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int price;

    public Chocolate(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Chocolate() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    void setId(long id) {
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
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
