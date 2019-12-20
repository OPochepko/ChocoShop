package by.pochepko.services;

import by.pochepko.model.Chocolate;
import by.pochepko.model.OrderLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DBChocoStockAlignerTest {

    @InjectMocks
    DBChocoStockAligner sut;

    @Mock
    DBService dbService;

    @Test
    void alignOrderLineWithStock_givenOrderlineQuantityIsOneHundredAndStockQuantityIsFifty_afterAligneOerdeQuantatyShouldBeFifty() {

        // given
        OrderLine orderLine = new OrderLine(new Chocolate(25, "Twinx"), 100);
        Mockito.when(dbService.getStockQuantityByChocolate(Mockito.any(Chocolate.class))).thenReturn(50);

        //when
        orderLine = sut.alignOrderLineWithStock(orderLine);

        //then
        assertThat(orderLine.getQuantity()).isEqualTo(50);

    }
}