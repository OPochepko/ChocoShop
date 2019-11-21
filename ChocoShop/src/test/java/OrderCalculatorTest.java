import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {

    static OrderCalculator orderCalculator;

    static Basket basket;

    static OrderLine orderLine1, orderLine2;

    static PromoCodes promoCode;

    static PromoCodeApplier promoCodeApplier;

    static TaxesCalculator taxesCalculator;

    @BeforeAll
    static void setUp(){
        ArrayList<OrderLine> order = new ArrayList<OrderLine>();

        orderLine1 = Mockito.mock(OrderLine.class);

        Mockito.when(orderLine1.getFullPrice()).thenReturn(10);

        order.add(orderLine1);

        orderLine2 = Mockito.mock(OrderLine.class);

        Mockito.when(orderLine2.getFullPrice()).thenReturn(10);

        order.add(orderLine2);


        basket = Mockito.mock(Basket.class);

        Mockito.when(basket.getOrder()).thenReturn(order);


        promoCode = Mockito.mock(PromoCodes.class);

        Mockito.when(basket.getPromoCode()).thenReturn(promoCode);


        promoCodeApplier = Mockito.mock(PromoCodeApplier.class);

        Mockito.when(promoCodeApplier.applyPromoCode(promoCode,100))
                .thenReturn(200);


        taxesCalculator = Mockito.mock(TaxesCalculator.class);

        Mockito.when(taxesCalculator.calculateTaxes(10)).thenReturn(50);


        orderCalculator = new OrderCalculator();

        orderCalculator.taxesCalculator = taxesCalculator;

        orderCalculator.promoCodeApplier = promoCodeApplier;






    }
    @Test
    void calculateOrderPrice() {

        Assertions.assertEquals(orderCalculator.calculateOrderPrice(basket),200);
    }
}