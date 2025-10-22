package week1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartCalculator {
    public static BigDecimal itemTotal(BigDecimal price, int quantity) {
        if (price == null || quantity < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return price.multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b).setScale(2, RoundingMode.HALF_UP);
    }
}
