import by.pochepko.services.TaxesCalculator;
import by.pochepko.services.TaxesCalculatorImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

        //when
        int totalCost = taxesCalculator.calculateTaxes(109);

        //then
        assertThat(totalCost).isEqualTo(122);
    }

}