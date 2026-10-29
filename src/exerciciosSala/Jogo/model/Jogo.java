package exerciciosSala.Jogo.model;

import exerciciosSala.Jogo.exception.JogadorInvalidoException;

import java.util.Random;

public abstract class Jogo {
    private int vitoriasJogador1;
    private int vitoriasJogador2;
    int totalPartidasDisputadas;


    public Jogo() {
        vitoriasJogador1 = 0;
        vitoriasJogador2 = 0;
        totalPartidasDisputadas = 0;
    }


    public void jogarUmaPartida(Jogador j1, Jogador j2) {
        int rodadas = 0;
        int pontosJogador1 = 0;
        int pontosJogador2 = 0;
        while (!partidaEncerrada(pontosJogador1, pontosJogador2, rodadas)) {
            if (executarAcao(1)) { pontosJogador1++; }
            if (executarAcao(2)) { pontosJogador2++; }
            rodadas++;
        }
        if (pontosJogador1 > pontosJogador2){
            j1.vitorias.put(j2, j1.vitorias.getOrDefault(j2, 0) + 1);
            vitoriasJogador1++;
        }
        else if (pontosJogador2 > pontosJogador1) {
            j2.vitorias.put(j1, j2.vitorias.getOrDefault(j1, 0) + 1);
            vitoriasJogador2++;
        };
        this.totalPartidasDisputadas++;
    }

    public boolean partidaEncerrada(int j1, int j2, int r){
        return j1 != j2;
    }

    public int getVitorias(int jogador) {
        if (jogador == 1) { return vitoriasJogador1; }
        else if (jogador == 2) { return vitoriasJogador2; }
        else { throw new JogadorInvalidoException(); }
    }

    protected abstract boolean executarAcao(int jogador);

    protected static int sortear(int n, int m){
        Random numero = new Random();
        return numero.nextInt(6) + 1;
    }
}

