package exerciciosSala_Backup.Fracao.src;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AritmeticaTeste {
    @Test
    public void testarMdc(){
//      mdc(81,45) = 9
        int a = 81;
        int b = 45;
        int c = Aritmetica.mdc(a, b);
        assertEquals(9, c);

//      mdc(189, 425) = 1
        a = 189;
        b = 425;
        c = Aritmetica.mdc(a, b);
        assertEquals(1, c);
    }
}
