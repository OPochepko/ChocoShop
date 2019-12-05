import by.pochepko.services.XMLPromocodeApplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PromoCodeApplierImplTest {


    private XMLPromocodeApplier promoCodeApplier;
    private int costAfterPromocodeApplied;


    @Test
    void applyPromoCode_CostAfterPromocodeAppliedShouldBeNinety() {
        // given
        promoCodeApplier = new XMLPromocodeApplier();
        promoCodeApplier.readPromocodes("src/test/resources/testPromocodes.xml");

        // when
        costAfterPromocodeApplied = promoCodeApplier.applyPromoCode("DECIMATION", 100);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(90);

    }


}