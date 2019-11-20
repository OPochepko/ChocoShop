import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxesCalculatorTest {

    @Test
    void calculateTaxes() {
        int costWithTaxes;

        costWithTaxes = (TaxesCalculator.calculateTaxes(109));

        Assertions.assertEquals(costWithTaxes, 122);

        costWithTaxes = (TaxesCalculator.calculateTaxes(100));

        Assertions.assertEquals(costWithTaxes, 112);

        costWithTaxes = (TaxesCalculator.calculateTaxes(50));

        Assertions.assertEquals(costWithTaxes, 62);
    }
}