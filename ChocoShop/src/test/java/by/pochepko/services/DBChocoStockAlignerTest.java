package by.pochepko.services;

import by.pochepko.dao.StockRepository;
import by.pochepko.model.Chocolate;
import by.pochepko.model.OrderLine;
import by.pochepko.model.Stock;
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
    StockRepository stockRepository;

    @Mock
    Stock stock;

    @Test
    void alignOrderLineWithStock_givenOrderlineQuantityIsOneHundredAndStockQuantityIsFifty_afterAligneOerdeQuantatyShouldBeFifty() {

        // given
        OrderLine orderLine = new OrderLine(new Chocolate(25, "Twinx"), 100);
        Mockito.when(stockRepository.findStockByChocolate(Mockito.any(Chocolate.class))).thenReturn(stock);
        Mockito.when(stock.getQuantity()).thenReturn(50);

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
    void alignOrderLineWithStock_givenOrderLineQuantityIsOneHundredAndStockIsOneHundred_QuantityShouldBeOneHundred() {
        // given
        OrderLine orderLine = new OrderLine(new Chocolate(25, "Twinx"), 100);
        Mockito.when(stockRepository.findStockByChocolate(Mockito.any(Chocolate.class))).thenReturn(stock);
        Mockito.when(stock.getQuantity()).thenReturn(100);

        //when
        orderLine = sut.alignOrderLineWithStock(orderLine);

        //then
        assertThat(orderLine.getQuantity()).isEqualTo(100);


    }
}