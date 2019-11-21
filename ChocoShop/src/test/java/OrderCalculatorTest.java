import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class OrderCalculatorTest {

    private Basket basket;

    private OrderLine orderLine1, orderLine2;

    private PromoCodes promoCode;

    @Mock private PromoCodeApplier promoCodeApplier;

    @Mock private TaxesCalculator taxesCalculator;

    @InjectMocks private OrderCalculator orderCalculator;

    @Test
    void calculateOrderPrice() {

        basket = new Basket();

        basket.setPromoCode(PromoCodes.DECIMATION);

        basket.put(new OrderLine(new Chocolate(25, "TWINX"),5));

        basket.put(new OrderLine(new Chocolate(10, "BOUNCY"),8));

        Mockito.when(promoCodeApplier.applyPromoCode(basket.getPromoCode(),100))
                .thenReturn(200);

        Mockito.when(taxesCalculator.calculateTaxes(Mockito.any(Integer.class))).thenReturn(50);

        Assertions.assertEquals(orderCalculator.calculateOrderPrice(basket),200);
    }
}