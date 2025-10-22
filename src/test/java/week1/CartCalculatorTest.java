package week1;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CartCalculatorTest {
    @Test
    void testItemTotal() {
        assertEquals(new BigDecimal("10.00"), CartCalculator.itemTotal(new BigDecimal("2.50"), 4));
    }

    @Test
    void testAdd() {
        assertEquals(new BigDecimal("7.00"), CartCalculator.add(new BigDecimal("2.50"), new BigDecimal("4.50")));
    }

    @Test
    void testNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> 
                CartCalculator.itemTotal(new BigDecimal("1.0"), -2));
    }
}
