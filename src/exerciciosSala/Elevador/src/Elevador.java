package exerciciosSala.Elevador.src;

import java.util.ArrayList;

public abstract class Elevador {
    private int cargaCorrente;
    private int andarCorrente;
    private int andarMaisAlto;
    private int cargaMaxima;
    private boolean subindo;
    private boolean movendo;
    protected ArrayList<Integer> paradas = new ArrayList<>();
    protected ArrayList<Integer> paradasEfetuadas = new ArrayList<>();

    public Elevador(int cargaMaxima, int andarMaisAlto) {
        this.andarCorrente = 0;
        this.cargaCorrente = 0;
        this.cargaMaxima = cargaMaxima;
        this.subindo = true;
        this.movendo = false;
        this.andarMaisAlto = andarMaisAlto;
    }

    public boolean isSubindo() {
        return subindo;
    }

    public void embarcar(int carga) {
        if ((this.cargaCorrente + carga) <= this.cargaMaxima) {
            this.cargaCorrente += carga;
        }
    }

    public void desembarcar(int carga) {
        if ((this.cargaCorrente - carga >= 0)) {
            this.cargaCorrente -= carga;
        }
    }
    /**
     * Retorna o histórico com todas as paradas efetuadas pelo
     * elevador desde a sua criação.
     *
     * @return Um ArrayList contendo a sequência de paradas que foram
     * realizadas.
     */
    public ArrayList<Integer> getParadasEfetuadas() {
        return paradasEfetuadas;
    }

    /**
     * Acrescenta uma solicitação de parada ao final da lista de solicitações.
     *
     * @param andar o andar desejado
     */
    public void solicitarParada(int andar) {
        if(andar < this.andarMaisAlto && andar >= 0) {
            this.paradas.add(andar);
        }
    }

    /**
     * Se o elevador encontrava-se parado, faz com que
     * ele se ponha em movimento e comece a
     * atender as solicitações de paradas em andares,
     * sempre a partir da primeira solicitação feita; após
     * atender a primeira solicitação, deve usar a lógica
     * implementada pelas subclasses
     * para decidir qual a próxima parada, e a próxima,
     * sucessivamente, até não ter mais solicitações para atender.
     *
     * Se o elevador já estava em movimento, nada acontece.
     */
    public void mover() {
        irPara(paradas.getFirst());
        movendo = true;
        while(!paradas.isEmpty()) {
            irPara(decidirProximaParada());
        }
        movendo = false;
    }

    /**
     * Vai para o andar informado como parâmetro. Ao chegar lá,
     * decide qual será a próxima parada e chama novamente o irPara, passando
     * como parâmetro essa próxima parada. Se não houver mais paradas solicitadas,
     * fica parado.
     *
     * @param andar O próximo destino.
     */
    private void irPara(int andar) {
        subindo = andar >= getAndarCorrente();
        this.andarCorrente = andar;
        paradasEfetuadas.add(andar);
        paradas.remove(Integer.valueOf(andar));
    }

    public int getAndarCorrente() {
        return andarCorrente;
    }

    /** Decide qual será a próxima parada, baseado no andar corrente,
     *  no sentido do movimento, e na lista de solicitações.
     *
     * Cada subclasse deve implementar a sua lógica.
     *
     * @return o próximo andar em que o elevador deverá parar
     */
    protected abstract int decidirProximaParada();
}

