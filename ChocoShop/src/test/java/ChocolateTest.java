import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChocolateTest {

    Chocolate chocolate;

    @BeforeEach
    void setUp(){
        chocolate = new Chocolate(99, "Jupiter");
    }

    @Test
    void getPrice() {

        Assertions.assertEquals(chocolate.getPrice(), 99);
    }

    @Test
    void getName() {

        Assertions.assertEquals(chocolate.getName(), "Jupiter");
    }
}