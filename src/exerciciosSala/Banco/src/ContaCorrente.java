package exerciciosSala.Banco.src;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class ContaCorrente {

    public static final float LIMITE_CHEQUE_ESPECIAL = 500;
    private static final Random GERADOR = new Random();
    public static final int MAXIMO_CEDULAS_POR_DEPOSITO = 50;

    // atributos
    private final Pessoa correntista;
    private float saldo;
    private String nome;
    private int agencia;
    private int numeroDaConta;
    private int digitoVerificador;
    private int senha;
    private ArrayList<String> extrato;  // veremos depois!!!

    public static int idBanco;  // todas as contas serão do mesmo banco!!!!
    private static int quantContasCriadas = 0;

    public ContaCorrente(Pessoa correntista) {
        quantContasCriadas++;

        this.correntista = correntista;  // associação (objeto pré-existente)
        this.saldo = quantContasCriadas == 100 ? 1050 : 50;  // saldo inicial (brinde)
        this.senha = GERADOR.nextInt(100000);
        this.extrato = new ArrayList<>();  // composição
    }

    public long getCpf() {
        return correntista.getCpf();
    }

    public void sacar(float valor) {
        if (saldo + LIMITE_CHEQUE_ESPECIAL < valor) {
            // O correto seria lançar uma exceção; veremos mais à frente!
            // no momento, simplesmente não faremos nada
            extrato.add("Tentativa de saque muito elevado");
        } else {
            saldo = saldo - valor;
        }
        extrato.add(String.format("Saque de R$%.2f efetuado.", valor));
    }

    public void transferir(float valor, ContaCorrente contaDestino) {
        if (saldo + LIMITE_CHEQUE_ESPECIAL < valor) {
            System.out.println("Saldo insuficiente");
            // ToDo lançar uma exceção
        } else {
            saldo -= valor;
            contaDestino.saldo += valor;
            extrato.add("Transferência feita...");
        }
    }

    public void imprimirExtrato() {
        for (String itemExtrato : extrato) {
            System.out.println(itemExtrato);
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public int getQuantContasCriadas() {
        return quantContasCriadas;
    }

    public void receberDeposito(float valor){
        if(valor > 0){
            this.saldo += valor;
        }
        else{
            System.out.println("Valor Invalido");
        }
    }

    public void receberDeposito(Map<Dinheiro, Integer> contDinheiroPorTipo) throws LimiteNotasExcedidoException {
        int notas = 0;
        float valor = 0;
        for (Map.Entry<Dinheiro, Integer> entry : contDinheiroPorTipo.entrySet()){
            Dinheiro chave = entry.getKey();
            Integer quant = entry.getValue();
            if(!chave.isMoeda())
                notas += quant;
            valor += chave.getValor() * quant;
        }
        if(notas > 50){
            throw new LimiteNotasExcedidoException("Limite de cedulas e 50");
        }
        else{
            receberDeposito(valor);
        }
    }
}




