package exerciciosSala.Jogo.model;

import java.util.HashMap;

public class Jogador {
    HashMap<Jogador, Integer> vitorias = new HashMap<>();
    public int getQuantidadeVitorias(Jogador adv){
        return this.vitorias.getOrDefault(adv, 0);
    }
}
