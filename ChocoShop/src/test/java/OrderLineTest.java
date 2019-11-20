import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineTest {
    static OrderLine orderLine;
    static Chocolate chocolate;

    @BeforeAll
    static void setUp(){
        chocolate = Mockito.mock(Chocolate.class);

        Mockito.when(chocolate.getPrice()).thenReturn(50);

        orderLine = new OrderLine(chocolate, 5);

    }

    @Test
    void getChocolate() {

        Assertions.assertEquals(chocolate, orderLine.getChocolate());

    }

    @Test
    void getQuantity() {

        Assertions.assertEquals(5, orderLine.getQuantity());
    }

    @Test
    void getFullPrice() {

        Assertions.assertEquals(250, orderLine.getFullPrice());
    }
}