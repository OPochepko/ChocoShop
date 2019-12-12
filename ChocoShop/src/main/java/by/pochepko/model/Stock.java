package by.pochepko.model;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @MapsId
    private Chocolate chocolate;

    private int quantity;

    public Stock() {
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public int getQuantity() {
        return quantity;
    }


}
