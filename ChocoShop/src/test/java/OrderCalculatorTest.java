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

    @Mock Basket basket;

    @Mock OrderLine orderLine1, orderLine2;

    @Mock PromoCodes promoCode;

    @Mock PromoCodeApplier promoCodeApplier;

    @Mock TaxesCalculator taxesCalculator;

    @InjectMocks OrderCalculator orderCalculator;

    @Test
    void calculateOrderPrice() {

        ArrayList<OrderLine> order = new ArrayList<OrderLine>();

        Mockito.when(orderLine1.getFullPrice()).thenReturn(10);

        order.add(orderLine1);

        Mockito.when(orderLine2.getFullPrice()).thenReturn(10);

        order.add(orderLine2);


        basket = Mockito.mock(Basket.class);

        Mockito.when(basket.getOrder()).thenReturn(order);

        Mockito.when(basket.getPromoCode()).thenReturn(promoCode);

        Mockito.when(promoCodeApplier.applyPromoCode(promoCode,100))
                .thenReturn(200);

        Mockito.when(taxesCalculator.calculateTaxes(10)).thenReturn(50);

        Assertions.assertEquals(orderCalculator.calculateOrderPrice(basket),200);
    }
}