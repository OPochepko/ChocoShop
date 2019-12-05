import by.pochepko.services.TaxesCalculator;
import by.pochepko.services.TaxesCalculatorImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TaxesCalculatorImplTest {

    private TaxesCalculator taxesCalculator;

    @Test
    void calculateTaxes_PriceIsOneHundred_TotalCostShouldBeOneHundredAndTwelve() {
        // given
        taxesCalculator = new TaxesCalculatorImpl();

        //when
        int totalCost = taxesCalculator.calculateTaxes(100);

        //then
        assertThat(totalCost).isEqualTo(112);
    }

    @Test
    void calculateTaxes_PriceIsOneHundredAndNine_TotalCostShouldBeOneHundredAndTwentyTwo() {
        //given
        taxesCalculator = new TaxesCalculatorImpl();
        int price = 109;

        //when
        int totalCost = taxesCalculator.calculateTaxes(price);

        //then
        assertThat(totalCost).isEqualTo(122);
    }

    @Test
    void calculateTaxes_PriceIsNegative_ShouldThrowException() {
        //given
        taxesCalculator = new TaxesCalculatorImpl();
        int price = -100;

        //then
        assertThatThrownBy(() -> {
            taxesCalculator.calculateTaxes(price);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price must be not negative: -100");


    }

}