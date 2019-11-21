import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PromoCodeApplierTest {


    private PromoCodeApplier promoCodeApplier = new PromoCodeApplier();

    @Test
    void applyPromoCode() {

        PromoCodes promoCodes = PromoCodes.DECIMATION;

        assertThat(promoCodeApplier.applyPromoCode(promoCodes,100)).isEqualTo(90);

    }


}