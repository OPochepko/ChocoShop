import by.pochepko.services.XMLPromocodeApplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class XMLPromocodeApplierTest {

    private XMLPromocodeApplier sut = new XMLPromocodeApplier();

    @Test
    void applyPromoCode_CostAfterPromocodeAppliedShouldBeNinety() {
        // given
        int cost = 100;
        sut.readPromocodes("src/test/resources/testPromocodes.xml");


        // when
        int costAfterPromocodeApplied = sut.applyPromoCode("DECIMATION", cost);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(90);

    }

    @Test
    void applyPromoCode_GivenInvalidCode_costAfterPromocodeAppliedShouldStay100() {
        // given
        int cost = 100;
        sut.readPromocodes("src/test/resources/testPromocodes.xml");


        // when
        int costAfterPromocodeApplied = sut.applyPromoCode("DECMATION", cost);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(100);


    }

    @Test
    void applyPromoCode_GivenNegativeCost_ShouldThrowException() {
        // given
        int cost = -100;
        sut.readPromocodes("src/test/resources/testPromocodes.xml");


        //when - then throws an exception
        assertThatThrownBy(() -> {
            sut.applyPromoCode("DECIMATION", cost);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cost must be not negative: -100");
    }


}


