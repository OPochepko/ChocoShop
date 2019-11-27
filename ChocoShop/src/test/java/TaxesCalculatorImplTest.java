import by.pochepko.services.TaxesCalculator;
import by.pochepko.services.TaxesCalculatorImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaxesCalculatorImplTest {

    private TaxesCalculator taxesCalculator = new TaxesCalculatorImpl();

    @Test
    void calculateTaxes() {
        int costWithTaxes;

        assertThat(taxesCalculator.calculateTaxes(109)).isEqualTo(122);

        assertThat(taxesCalculator.calculateTaxes(100)).isEqualTo(112);

        assertThat(taxesCalculator.calculateTaxes(50)).isEqualTo(62);


    }
}