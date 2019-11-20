import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PromoCodeApplierTest {
    PromoCodes promoCodes = Mockito.mock(PromoCodes.class);


    @Test
    void applyPromoCode10Percent() {

        Mockito.when(promoCodes.getFixDiscount()).thenReturn(0);

        Mockito.when(promoCodes.getPercentDiscount()).thenReturn(10);

        Assertions.assertEquals(PromoCodeApplier.applyPromoCode(promoCodes, 100d), 90d);


    }

    @Test
    void applyPromoCode10Rubbles() {

        Mockito.when(promoCodes.getFixDiscount()).thenReturn(15);

        Mockito.when(promoCodes.getPercentDiscount()).thenReturn(0);

        Assertions.assertEquals(PromoCodeApplier.applyPromoCode(promoCodes, 100d), 85d);


    }



}