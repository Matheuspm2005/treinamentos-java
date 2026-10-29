package exerciciosSala.Jogo.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JogoTest {

    @Test
    public void testPartidasDisputadas(){
        Jogo teste = new TrioOuDoisParesConsecutivos();
        teste.jogarUmaPartida();
        teste.jogarUmaPartida();
        teste.jogarUmaPartida();
        assertEquals( 3 , teste.totalPartidasDisputadas);
        Jogo semifinal = new TrioOuDoisParesConsecutivos();
        Jogo decisao = teste;
        teste = semifinal;
        teste.jogarUmaPartida();
        assertEquals( 1 , semifinal.totalPartidasDisputadas);
        decisao.jogarUmaPartida();
        assertEquals( 4 , decisao.totalPartidasDisputadas);
    }


}
