package by.pochepko.service;

import by.pochepko.model.Basket;
import by.pochepko.model.Chocolate;
import by.pochepko.model.OrderLine;
import by.pochepko.model.Promocode;
import by.pochepko.repository.PromocodeRepository;
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
    @Mock
    private Promocode promocode;

    @Mock
    private PromocodeApplierFactory promocodeApplierFactory;

    @Mock
    PromocodeRepository promocodeRepository;

    @Mock
    private PromocodeApplier promoCodeApplier;

    @Mock
    private TaxesCalculator taxesCalculator;

    @InjectMocks
    private OrderCalculatorImpl sut;

    @Test
    void calculateOrderPrice_twoOrderlinesInBasketPromocodeaAndTaxesApplied_totalPriceShouldBeTwoHundreds() {
        // given
        Basket basket = new Basket();
        basket.setPromoCode("Decimation");
        basket.put(new OrderLine(new Chocolate(25, "TWINX"), 5));
        basket.put(new OrderLine(new Chocolate(10, "BOUNCY"), 8));
        Mockito.when(promocodeApplierFactory.getPromocodeApplier(promocode.getClass())).thenReturn(promoCodeApplier);
        Mockito.when(promocodeRepository.findByCode(basket.getPromoCode())).thenReturn(promocode);
        Mockito.when(promoCodeApplier.applyPromoCode(100, promocode))
                .thenReturn(200);
        Mockito.when(taxesCalculator.calculateTaxes(Mockito.any(Integer.class))).thenReturn(50);

        //when
        int totalPrice = sut.calculateOrderPrice(basket);

        //then
        assertThat(totalPrice).isEqualTo(200);
        verify(taxesCalculator, Mockito.times(2))
                .calculateTaxes(Mockito.any(Integer.class));
        verify(promoCodeApplier, Mockito.times(1))
                .applyPromoCode(100, promocode);

    }

    @Test
    void calculateOrderPrice_GivenNULLBasket_ShouldThrowNullPointerException() {
        //given
        Basket basket = null;

        //when - then throws an exception
        assertThatThrownBy(() -> {
            sut.calculateOrderPrice(basket);

        }).isInstanceOf(NullPointerException.class)
                .hasMessage("The basket must not be null");
    }
}