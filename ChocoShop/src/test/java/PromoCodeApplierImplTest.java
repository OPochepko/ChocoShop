import by.pochepko.PromoCode;
import by.pochepko.PromoCodes;
import by.pochepko.services.PromoCodeApplierImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PromoCodeApplierImplTest {


    private PromoCodeApplierImpl promoCodeApplier;
    private PromoCodes promoCodes;
    private int costAfterPromocodeApplied;


    @Test
    void applyPromoCode_CostAfterPromocodeAppliedShouldBeNinety() {
        // given
        promoCodes = new PromoCodes();
        promoCodes.add(new PromoCode("Decimation", 0, 10));
        promoCodeApplier = new PromoCodeApplierImpl(promoCodes);

        // when
        costAfterPromocodeApplied = promoCodeApplier.applyPromoCode("Decimation", 100);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(90);

    }


}