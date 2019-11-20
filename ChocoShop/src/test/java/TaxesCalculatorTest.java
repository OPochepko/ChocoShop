import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxesCalculatorTest {

    @Test
    void calculateTaxes() {
        int costWithTaxesCents;

        costWithTaxesCents = (int) TaxesCalculator.calculateTaxes(150) * 100;

        Assertions.assertEquals(costWithTaxesCents, 16800);

        costWithTaxesCents = (int) TaxesCalculator.calculateTaxes(100) * 100;

        Assertions.assertEquals(costWithTaxesCents, 11200);

        costWithTaxesCents = (int) TaxesCalculator.calculateTaxes(50) * 100;

        Assertions.assertEquals(costWithTaxesCents, 6200);
    }
}