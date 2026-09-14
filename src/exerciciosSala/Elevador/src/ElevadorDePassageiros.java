package exerciciosSala.Elevador.src;

public class ElevadorDePassageiros extends Elevador {

    public ElevadorDePassageiros(int quantAndares, int cargaMaxima) {
        super(cargaMaxima, quantAndares);
    }

    @Override
    protected int decidirProximaParada() {
        if(this.isSubindo()){
            for (Integer parada : this.paradas) {
                if (parada >= this.getAndarCorrente())
                    return parada;
            }
        }
        else{
            for (Integer parada : this.paradas) {
                if (parada <= this.getAndarCorrente())
                    return parada;
            }
        }
        return this.paradas.getFirst();
    }
}

