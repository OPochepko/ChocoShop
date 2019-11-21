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

    @Mock
    PromoCodes promoCodes;

    static PromoCodeApplier promoCodeApplier;

    @BeforeAll
    static void setUp() {
        promoCodeApplier = new PromoCodeApplier();
    }

    @Test
    void applyPromoCode10Percent() {

        Mockito.when(promoCodes.getFixDiscount()).thenReturn(0);

        Mockito.when(promoCodes.getPercentDiscount()).thenReturn(10);

        Assertions.assertEquals(promoCodeApplier.applyPromoCode(promoCodes, 100), 90);
    }

    @Test
    void applyPromoCode10Rubbles() {

        Mockito.when(promoCodes.getFixDiscount()).thenReturn(10);

        Mockito.when(promoCodes.getPercentDiscount()).thenReturn(0);

        Assertions.assertEquals(promoCodeApplier.applyPromoCode(promoCodes, 100), 90);


    }



}