import by.pochepko.*;
import by.pochepko.services.OrderCalculatorImpl;
import by.pochepko.services.PromoCodeApplierImpl;
import by.pochepko.services.TaxesCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderCalculatorImplTest {

    @Mock private PromoCodeApplierImpl promoCodeApplier;

    @Mock private TaxesCalculator taxesCalculator;

    @InjectMocks private OrderCalculatorImpl orderCalculator;

    @Test
    void calculateOrderPrice() {
        Basket basket = new Basket();;

        basket.setPromoCode(PromoCodes.DECIMATION);

        basket.put(new OrderLine(new Chocolate(25, "TWINX"),5));

        basket.put(new OrderLine(new Chocolate(10, "BOUNCY"),8));

        Mockito.when(promoCodeApplier.applyPromoCode(basket.getPromoCode(),100))
                .thenReturn(200);

        Mockito.when(taxesCalculator.calculateTaxes(Mockito.any(Integer.class))).thenReturn(50);


        assertThat(orderCalculator.calculateOrderPrice(basket)).isEqualTo(200);

        verify(taxesCalculator, Mockito.times(2))
                .calculateTaxes(Mockito.any(Integer.class));

        verify(promoCodeApplier,Mockito.times(1))
                .applyPromoCode(basket.getPromoCode(),100);

    }
}