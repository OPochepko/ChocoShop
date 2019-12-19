package by.pochepko.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "promocodes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pc_type")
@XmlRootElement(name = "promocode")
public abstract class Promocode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String code;

    public Promocode() {
    }


    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public int getId() {
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
