package by.pochepko.service;

import by.pochepko.model.PercentDiscountPromocode;
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
class PercentDiscountPromocodeApplierTest {
    @Mock
    PercentDiscountPromocode promocode;
    @InjectMocks
    private PercentDiscountPromocodeApplier sut;

    @Test
    void applyPromoCode_givenPromocodeForTenPercentDiscountAndCostTwoHundred_costAterPromocodeApplingShouldBeOneHundredEighty() {
        //given
        int cost = 200;
        Mockito.when(promocode.getPercentDiscount()).thenReturn(10);

        //when
        int costAfterPromocodeApplied = sut.applyPromoCode(200, promocode);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(180);
        verify(promocode, Mockito.times(1)).getPercentDiscount();
    }

    @Test
    void applyPromocode_givenNullPromocodeAndCostTwoHundred_costAfterPromocodeAppliedShoulBeTwoHundred() {
        //given
        promocode = null;
        int cost = 200;

        //when
        int costAfterPromocodeApplied = sut.applyPromoCode(cost, promocode);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(200);
    }

    @Test
    void applyPromocode_givenNegativeCost_ShouldThrowException() {
        //given
        int cost = -100;
        promocode = null;


        //when - then throw Exception
        assertThatThrownBy(() -> {
            sut.applyPromoCode(cost, promocode);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Cost must be not negative: -100");
    }

}