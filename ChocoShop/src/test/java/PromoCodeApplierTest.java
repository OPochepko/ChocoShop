import by.pochepko.PromoCodes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import by.pochepko.services.PromoCodeApplierImpl;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PromoCodeApplierTest {


    private PromoCodeApplierImpl promoCodeApplier = new PromoCodeApplierImpl();

    @Test
    void applyPromoCode() {

        PromoCodes promoCodes = PromoCodes.DECIMATION;

        assertThat(promoCodeApplier.applyPromoCode(promoCodes,100)).isEqualTo(90);



    }


}