package exerciciosSala.Album;

public class Selo implements Colecionavel{
    private final int posicao;
    private final Object conteudo;

    public Selo(int pos, Object conteudo){
        this.posicao = pos;
        this.conteudo = conteudo;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }
}
