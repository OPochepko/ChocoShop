package by.pochepko.dao;


import by.pochepko.SpringBtApplication;
import com.google.common.collect.Iterators;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        classes = SpringBtApplication.class)
class ChocolateRepositoryTest {

    @Autowired
    private ChocolateRepository chocolateRepository;

    @Test
    public void chocolateRepositoryTest_chocolateRepositoryShoulContainTwoElements() {

        assertThat(Iterators.size(chocolateRepository.findAll().iterator())).isEqualTo(2);

    }

}