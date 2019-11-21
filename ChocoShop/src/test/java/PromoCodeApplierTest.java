import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PromoCodeApplierTest {

    private PromoCodes promoCodes = PromoCodes.DECIMATION;

    private PromoCodeApplier promoCodeApplier = new PromoCodeApplier();

    @Test
    void applyPromoCode() {

        Assertions.assertEquals(promoCodeApplier.applyPromoCode(promoCodes, 100), 90);
    }


}