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

    @Test
    void applyPromoCode() {
        PromoCodes promoCodes = new PromoCodes();
        promoCodes.add(new PromoCode("Decimation", 0, 10));
        promoCodeApplier = new PromoCodeApplierImpl(promoCodes);
        assertThat(promoCodeApplier.applyPromoCode("Decimation", 100)).isEqualTo(90);


    }


}