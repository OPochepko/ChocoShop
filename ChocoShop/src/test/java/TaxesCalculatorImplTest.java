import by.pochepko.services.TaxesCalculator;
import by.pochepko.services.TaxesCalculatorImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TaxesCalculatorImplTest {

    private TaxesCalculator sut = new TaxesCalculatorImpl();

    @Test
    void calculateTaxes_PriceIsOneHundred_TotalCostShouldBeOneHundredAndTwelve() {
        // given
        int price = 100;

        //when
        int totalCost = sut.calculateTaxes(price);

        //then
        assertThat(totalCost).isEqualTo(112);
    }

    @Test
    void calculateTaxes_PriceIsOneHundredAndNine_TotalCostShouldBeOneHundredAndTwentyTwo() {
        //given
        int price = 109;

        //when
        int totalCost = sut.calculateTaxes(price);

        //then
        assertThat(totalCost).isEqualTo(122);
    }

    @Test
    void calculateTaxes_PriceIsNegative_ShouldThrowException() {
        //given
        int price = -100;

        //when - then throws an exception
        assertThatThrownBy(() -> {
            sut.calculateTaxes(price);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price must be not negative: -100");


    }

}