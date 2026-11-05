package exerciciosSala.Album;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Album <T extends Colecionavel>{
    Map<Integer, T> album;
    Map<Integer, Integer> repetidas;
    private final int quantFigurinhas;
    private final int quantFigurinhasPorPacote;

    public Album(int quantidade, int pacote) {
        this.repetidas = new HashMap<>();
        this.album = new HashMap<>();
        this.quantFigurinhas = quantidade;
        this.quantFigurinhasPorPacote = pacote;
    }

    public int getRepetidas(int pos){
        if (pos < 0 || pos > quantFigurinhas)
            throw new PosicaoInvalidaException("Posicao Invalida");
        return repetidas.getOrDefault(pos, 0);
    }

    public boolean contemItem(int pos){
        return album.containsKey(pos);
    }

    public void receberPacotinho(ArrayList<T> pacotinho) throws QuantidadeInvalidaException{
        if(pacotinho != null && pacotinho.size() != quantFigurinhasPorPacote)
            throw new QuantidadeInvalidaException("Quantidade diferente da permitida");
        for(T item : pacotinho){
            int pos = item.getPosicao();
            if(this.album.containsKey(pos)) {
                this.repetidas.put(pos, repetidas.getOrDefault(pos, 0) + 1);
            }
            else
                this.album.put(pos, item);
        }
    }

    public int getPercentualCompleto(){
        return Math.round((float) album.size() /quantFigurinhas * 100);
    }

    public T getItem(int pos){
        return album.getOrDefault(pos, null);
    }
}
