import by.pochepko.services.XMLPromocodeApplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class XMLPromocodeApplierTest {


    private XMLPromocodeApplier promoCodeApplier;
    private int costAfterPromocodeApplied;


    @Test
    void applyPromoCode_CostAfterPromocodeAppliedShouldBeNinety() {
        // given
        promoCodeApplier = new XMLPromocodeApplier();
        promoCodeApplier.readPromocodes("src/test/resources/testPromocodes.xml");
        int cost = 100;

        // when
        costAfterPromocodeApplied = promoCodeApplier.applyPromoCode("DECIMATION", cost);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(90);

    }

    @Test
    void applyPromoCode_GivenInvalidCode_costAfterPromocodeAppliedShouldStay100() {
        // given
        promoCodeApplier = new XMLPromocodeApplier();
        promoCodeApplier.readPromocodes("src/test/resources/testPromocodes.xml");
        int cost = 100;

        // when
        costAfterPromocodeApplied = promoCodeApplier.applyPromoCode("DECMATION", cost);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(100);


    }

    @Test
    void applyPromoCode_GivenNegativeCost_ShouldThrowException() {
        // given
        promoCodeApplier = new XMLPromocodeApplier();
        promoCodeApplier.readPromocodes("src/test/resources/testPromocodes.xml");
        int cost = -100;

        //
        assertThatThrownBy(() -> {
            promoCodeApplier.applyPromoCode("DDECIMATION", cost);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cost must be not negative: -100");
    }


}


