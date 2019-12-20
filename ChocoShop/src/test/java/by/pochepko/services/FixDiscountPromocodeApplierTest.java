package by.pochepko.services;

import by.pochepko.model.FixDiscontPromocode;
import by.pochepko.model.Promocode;
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
class FixDiscountPromocodeApplierTest {
    @Mock
    FixDiscontPromocode promocode;
    @InjectMocks
    private FixDiscountPromocodeApplier sut;

    @Test
    void applyPromoCode_givenPromocodeForOneHundredDiscountAndCostTwoHundred_costAterPromocodeApplingShouldBeOeHundred() {
        //given
        int cost = 200;
        Mockito.when(promocode.getFixDiscount()).thenReturn(100);

        //when
        int costAfterPromocodeApplied = sut.applyPromoCode(200);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(100);
        verify(promocode, Mockito.times(1)).getFixDiscount();
    }

    @Test
    void applyPromocode_givenNullPromocodeAndCostTwoHundred_costAfterPromocodeAppliedShoulBeTwoHundred() {
        //given
        Promocode promocode = null;
        int cost = 200;
        sut.setPromocode(promocode);

        //when
        int costAfterPromocodeApplied = sut.applyPromoCode(cost);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(200);
    }

    @Test
    void applyPromocode_givenNegativeCost_ShouldThrowException() {
        //given
        int cost = -100;

        //when - then throw Exception
        assertThatThrownBy(() -> {
            sut.applyPromoCode(cost);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Cost must be not negative: -100");
    }
}