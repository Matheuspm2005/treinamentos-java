package exerciciosSala.Jogo.model;

public class TrioOuDoisParesConsecutivos extends Jogo {

    protected boolean executarAcao(int jogador) {
        int a = sortear(1, 6);
        int b = sortear(1, 6);
        int c = sortear(1, 6);
        if (jogador == 1) {  // se for o jogador 1,
            return (a==b) && (b==c);  // pontua com três resultados iguais nos dados
        }
        int d = sortear(1, 6); // se for outro jogador, joga o dado uma quarta vez,
        return (a==b) && (c==d);  // e pontua com dois resultados iguais, duas vezes
    }


    public boolean partidaEncerrada(int pontos1, int pontos2, int rodadas) {
        return pontos1 != pontos2;
    }
}
