package by.pochepko.services;

import by.pochepko.PromoCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HibernateDBServiceTest {
    HibernateDBService sut = new HibernateDBService();

    @Test
    void readPromocodes() {
        //when
        List<PromoCode> promoCodes = sut.readPromocodes();

        //then
        assertThat(promoCodes.get(0).getCode()).isEqualTo("DECIMATION");
        System.out.println(promoCodes.get(1));


    }
}