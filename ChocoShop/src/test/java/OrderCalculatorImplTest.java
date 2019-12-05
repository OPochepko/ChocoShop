import by.pochepko.Basket;
import by.pochepko.Chocolate;
import by.pochepko.OrderLine;
import by.pochepko.services.OrderCalculatorImpl;
import by.pochepko.services.TaxesCalculator;
import by.pochepko.services.XMLPromocodeApplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderCalculatorImplTest {

    private Basket basket = new Basket();

    @Mock
    private XMLPromocodeApplier promoCodeApplier;

    @Mock
    private TaxesCalculator taxesCalculator;

    @InjectMocks
    private OrderCalculatorImpl sut;

    @Test
    void calculateOrderPrice_twoOrderlinesInBasketPromocodeaAndTaxesApplied_totalPriceShouldBeTwoHundreds() {
        // given
        basket.setPromoCode("Decimation");
        basket.put(new OrderLine(new Chocolate(25, "TWINX"), 5));
        basket.put(new OrderLine(new Chocolate(10, "BOUNCY"), 8));
        Mockito.when(promoCodeApplier.applyPromoCode(basket.getPromoCode(), 100))
                .thenReturn(200);
        Mockito.when(taxesCalculator.calculateTaxes(Mockito.any(Integer.class))).thenReturn(50);

        //when
        int totalPrice = sut.calculateOrderPrice(basket);

        //then
        assertThat(totalPrice).isEqualTo(200);
        verify(taxesCalculator, Mockito.times(2))
                .calculateTaxes(Mockito.any(Integer.class));
        verify(promoCodeApplier, Mockito.times(1))
                .applyPromoCode(basket.getPromoCode(), 100);

    }

    @Test
    void calculateOrderPrice_GivenNULLBasket_ShouldThrowNullPointerException() {
        //given
        basket = null;

        //when - then throws an exception
        assertThatThrownBy(() -> {
            sut.calculateOrderPrice(basket);

        }).isInstanceOf(NullPointerException.class)
                .hasMessage("The basket must not be null");
    }
}