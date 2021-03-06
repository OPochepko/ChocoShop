package by.pochepko.model;

import javax.persistence.*;

@Entity
@Table(name = "promocodes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pc_type")
public abstract class Promocode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    public Promocode() {
    }


    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "PromoCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
