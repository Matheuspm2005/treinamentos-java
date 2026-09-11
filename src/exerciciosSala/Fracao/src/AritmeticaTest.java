package exerciciosSala.Fracao.src;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AritmeticaTest {

    @Test
    public void testarMdc() {
        assertEquals(4,
                Aritmetica.mdc(8, 4));
        assertEquals(4,
                Aritmetica.mdc(4, 8));
        assertEquals(1,
                Aritmetica.mdc(8, 25));
        assertEquals(709,
                Aritmetica.mdc(709, 709));
    }

    @Test
    public void testarMmc() {
        assertEquals(30,
                Aritmetica.mmc(10, 30));
        assertEquals(52,
                Aritmetica.mmc(52, 52));
    }
}