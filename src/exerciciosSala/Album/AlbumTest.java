package exerciciosSala.Album;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class AlbumTest {
    private Album<Colecionavel> albumDeFigurinhas;
    private Figurinha figurinha1 = new Figurinha(10, "imagem");
    private Figurinha figurinha2 = new Figurinha(11, "imagem");
    private Figurinha figurinha3 = new Figurinha(12, "imagem");
    private Selo selo1 = new Selo(15, "simbolo");
    ArrayList<Colecionavel> pacote = new ArrayList<>();

    @Before
    public void SetUp(){
        albumDeFigurinhas = new Album<>(100, 5);
        albumDeFigurinhas.album.put(10, figurinha1);
        albumDeFigurinhas.repetidas.put(10, 1);
    }

    @Test
    public void testePosicaoNegativa(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            albumDeFigurinhas.getRepetidas(-1);
        });
        assertEquals("Posicao Invalida", exception.getMessage());
    }

    @Test
    public void testePosicaoAcimaDaPermitida(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            albumDeFigurinhas.getRepetidas(101);
        });
        assertEquals("Posicao Invalida", exception.getMessage());
    }

    @Test
    public void testeGetRepetida(){
        assertEquals("A função deve retornar a quantidade de figurinhas repetidas naquela posicao",1, albumDeFigurinhas.getRepetidas(10));
        assertEquals("A função deve retornar um valor padrão 0 se a figurinha nao estiver contida no album", 0, albumDeFigurinhas.getRepetidas(11));
    }

    @Test
    public void testeContemItem(){
        assertTrue(albumDeFigurinhas.contemItem(10));
        assertFalse(albumDeFigurinhas.contemItem(11));
    }

    @Test
    public void testeReceberPacotinhoComQuantidadeInvalida(){
        Collections.addAll(pacote, figurinha1, figurinha2, figurinha3, figurinha2, figurinha1, figurinha3);
        QuantidadeInvalidaException exception = assertThrows(QuantidadeInvalidaException.class, () -> {
            albumDeFigurinhas.receberPacotinho(pacote);
        });
        assertEquals("Quantidade diferente da permitida", exception.getMessage());
    }

    @Test
    public void testeReceberPacotinho() throws QuantidadeInvalidaException {
        Collections.addAll(pacote, figurinha1, figurinha2, figurinha3, figurinha2, figurinha1);
        albumDeFigurinhas.receberPacotinho(pacote);
        HashMap<Integer, Colecionavel> albumEsperado = new HashMap<>();
        HashMap<Integer, Integer> repetidasEsperadas = new HashMap<>();
        albumEsperado.put(10, figurinha1);
        albumEsperado.put(11, figurinha2);
        albumEsperado.put(12, figurinha3);
        repetidasEsperadas.put(10, 3);
        repetidasEsperadas.put(11, 1);
        assertEquals(albumEsperado, albumDeFigurinhas.album);
        assertEquals(repetidasEsperadas, albumDeFigurinhas.repetidas);
    }

    @Test
    public void testarGetPercentualCompleto(){
        assertEquals(1, albumDeFigurinhas.getPercentualCompleto());
    }

    @Test
    public void testarGetItem(){
        assertEquals(figurinha1, albumDeFigurinhas.getItem(10));
    }
}
