package by.pochepko.services.main;

import by.pochepko.model.PromoCode;
import by.pochepko.services.DBService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DBPromocodeApplierTest {
    @Mock
    private static DBService dbService;


    @InjectMocks
    private static DBPromocodeApplier sut = new DBPromocodeApplier();


    @Test
    void applyPromoCode_CostAfterPromocodeAppliedShouldBeNinety() {
        //given
        String code = "Decimation";
        int cost = 100;
        Mockito.when(dbService.getPromocodeByCode(code)).
                thenReturn(new PromoCode(code, 0, 10));

        //when
        int costAfterPromocodeApplied = sut.applyPromoCode(code, cost);

        //then
        assertThat(costAfterPromocodeApplied).isEqualTo(90);

    }


}