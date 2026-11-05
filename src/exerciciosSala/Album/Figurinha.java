package exerciciosSala.Album;

public class Figurinha implements Colecionavel {
    private final int posicao;
    private final Object conteudo;

    public Figurinha(int pos, Object conteudo) {
        this.posicao = pos;
        this.conteudo = conteudo;
    }

    @Override
    public int getPosicao() {
        return 0;
    }
}
