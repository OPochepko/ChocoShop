import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

class TaxesCalculatorTest {

    private TaxesCalculator taxesCalculator = new TaxesCalculator();

    @Test
    void calculateTaxes() {
        int costWithTaxes;

        assertThat(taxesCalculator.calculateTaxes(109)).isEqualTo(122);

        assertThat(taxesCalculator.calculateTaxes(100)).isEqualTo(112);

        assertThat(taxesCalculator.calculateTaxes(50)).isEqualTo(62);


    }
}