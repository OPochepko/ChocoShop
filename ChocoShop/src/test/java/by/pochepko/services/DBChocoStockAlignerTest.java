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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void alignOrderLineWithStock_givenOrderLineIsNull_shouldThrowException() {

        // given
        OrderLine orderLine = null;

        // when - then
        assertThatThrownBy(() -> {
            sut.alignOrderLineWithStock(orderLine);

        }).isInstanceOf(NullPointerException.class)
                .hasMessage("Order should not be NULL");

    }

    @Test
    void alignOrderLineWithStock_gevenOrderLineQuantityIsOneHundredAndStockIsOneHundred() {
        // given
        OrderLine orderLine = new OrderLine(new Chocolate(25, "Twinx"), 100);
        Mockito.when(dbService.getStockQuantityByChocolate(Mockito.any(Chocolate.class))).thenReturn(100);

        //when
        orderLine = sut.alignOrderLineWithStock(orderLine);

        //then
        assertThat(orderLine.getQuantity()).isEqualTo(100);


    }
}