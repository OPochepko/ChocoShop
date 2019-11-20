import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    static OrderLine orderLine1, orderLine2, orderLine3;

    static PromoCodes promoCode;

    static Basket basket = new Basket();
    @BeforeAll
    static void setUp() {
        promoCode = Mockito.mock(PromoCodes.class);

        basket.setPromoCode(promoCode);

        orderLine1 = Mockito.mock(OrderLine.class);

        orderLine2 = Mockito.mock(OrderLine.class);

        orderLine3 = Mockito.mock(OrderLine.class);

        basket.put(orderLine1);

        basket.put(orderLine2);

        basket.put(orderLine3);


    }

    @Test
    void basket() {

        Assertions.assertTrue(basket.getOrder().contains(orderLine1));

        Assertions.assertTrue(basket.getOrder().contains(orderLine2));

        Assertions.assertTrue(basket.getOrder().contains(orderLine3));

        basket.remove(1);

        Assertions.assertFalse(basket.getOrder().contains(orderLine2));

        Assertions.assertEquals(basket.getPromoCode(), promoCode);

    }


}