package by.pochepko.model;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private Chocolate chocolate;

    private int quantity;

    public Stock() {
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    private void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", chocolate=" + chocolate +
                ", quantity=" + quantity +
                '}';
    }
}
