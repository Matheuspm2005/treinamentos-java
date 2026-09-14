package exerciciosSala.Elevador.src;

public class ElevadorDeCarga extends Elevador {

    public ElevadorDeCarga(int quantAndares, int cargaMaxima) {
        super(cargaMaxima, quantAndares);
    }

    @Override
    protected int decidirProximaParada() {
        return paradas.getFirst();
    }

}
