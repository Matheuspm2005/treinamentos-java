package exerciciosSala.Jogo.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JogoTest {

    @Test
    public void testPartidasDisputadas(){
        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        Jogo teste = new TrioOuDoisParesConsecutivos();
        teste.jogarUmaPartida(j1, j2);
        teste.jogarUmaPartida(j1, j2);
        teste.jogarUmaPartida(j1, j2);
        assertEquals( 3 , teste.totalPartidasDisputadas);
        Jogo semifinal = new TrioOuDoisParesConsecutivos();
        Jogo decisao = teste;
        teste = semifinal;
        teste.jogarUmaPartida(j1, j2);
        assertEquals( 1 , semifinal.totalPartidasDisputadas);
        decisao.jogarUmaPartida(j1, j2);
        assertEquals( 4 , decisao.totalPartidasDisputadas);
    }


}
