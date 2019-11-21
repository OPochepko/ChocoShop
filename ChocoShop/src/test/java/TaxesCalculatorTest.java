import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxesCalculatorTest {

    private TaxesCalculator taxesCalculator = new TaxesCalculator();

    @Test
    void calculateTaxes() {
        int costWithTaxes;

        costWithTaxes = (taxesCalculator.calculateTaxes(109));

        Assertions.assertEquals(costWithTaxes, 122);

        costWithTaxes = (taxesCalculator.calculateTaxes(100));

        Assertions.assertEquals(costWithTaxes, 112);

        costWithTaxes = (taxesCalculator.calculateTaxes(50));

        Assertions.assertEquals(costWithTaxes, 62);
    }
}