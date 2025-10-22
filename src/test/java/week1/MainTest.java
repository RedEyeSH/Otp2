package week1;

import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testLocaleSwitch() {
        assertEquals(new Locale("en", "US"), Main.getLocaleFromChoice(1));
        assertEquals(new Locale("fi", "FI"), Main.getLocaleFromChoice(2));
        assertEquals(new Locale("sv", "SE"), Main.getLocaleFromChoice(3));
        assertEquals(new Locale("ja", "JP"), Main.getLocaleFromChoice(4));
    }
}
