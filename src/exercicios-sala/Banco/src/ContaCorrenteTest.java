import org.junit.Test;
import static org.junit.Assert.*;

public class ContaCorrenteTest {

    final float ACCEPTED_FLOAT_DELTA = 0.00001f;

    @Test
    public void testarSaqueComContaSemSaldoSuficienteEForaDoLimite() {
        // prepara o cenário de teste
        ContaCorrente contaTeste = new ContaCorrente(123);
        float saldoAntesDoSaque = contaTeste.getSaldo();
        float valorDoSaque = saldoAntesDoSaque + ContaCorrente.LIMITE_CHEQUE_ESPECIAL + 10;

        // chama o metodo que desejamos testar
        contaTeste.sacar(valorDoSaque);

        // verifica o efeito
        assertEquals("O saldo não deve ser alterado diante de um saque com valor maior do que ele " +
                        " e que estoure o limite do cheque especial",
                saldoAntesDoSaque,
                contaTeste.getSaldo(), ACCEPTED_FLOAT_DELTA);
    }

    @Test
    public void testarSaqueComContaSemSaldoSuficienteMasDentroDoLimite() {
        // prepara o cenário de teste
        ContaCorrente contaTeste = new ContaCorrente(123);
        float saldoAntesDoSaque = contaTeste.getSaldo();
        float valorDoSaque = saldoAntesDoSaque + ContaCorrente.LIMITE_CHEQUE_ESPECIAL - 5;

        // chama o metodo que desejamos testar
        contaTeste.sacar(valorDoSaque);

        // verifica o efeito
        assertEquals("O saldo deve diminuir, ficando negativo, após um saque " +
                        "de valor muito alto mas dentro do limite do cheque especial",
                saldoAntesDoSaque - valorDoSaque,
                contaTeste.getSaldo(), ACCEPTED_FLOAT_DELTA);
    }

    @Test
    public void testarSaqueBemSucedido() {
        // prepara o cenário de teste
        ContaCorrente contaTeste = new ContaCorrente(123);
        float saldoAntesDoSaque = contaTeste.getSaldo();
        float valorDoSaque = 1.00f;

        // chama o metodo que desejamos testar
        contaTeste.sacar(valorDoSaque);

        // verifica o efeito
        assertEquals("O saldo deve diminuir após um saque",
                saldoAntesDoSaque - valorDoSaque,
                contaTeste.getSaldo(), ACCEPTED_FLOAT_DELTA);
    }

    @Test
    public void testarTransferênciaBemSucedida() {
        // prepara o cenário de teste
        ContaCorrente contaOrigem = new ContaCorrente(123);
        float saldoAntesDaTransferenciaNaContaOrigem = contaOrigem.getSaldo();

        ContaCorrente contaDestino = new ContaCorrente(3465);
        float saldoAntesDaTransferenciaNaContaDestino = contaDestino.getSaldo();

        float valorDaTransferencia = 1.00f;

        // chama o metodo desejado
        contaOrigem.transferir(valorDaTransferencia, contaDestino);

        assertEquals("O saldo na conta de origem deve diminuir após receber " +
                        "uma transferência",
                saldoAntesDaTransferenciaNaContaOrigem - valorDaTransferencia,
                contaOrigem.getSaldo(), ACCEPTED_FLOAT_DELTA);
        assertEquals("O saldo na conta de destino deve aumentar após receber " +
                        "uma transferência",
                saldoAntesDaTransferenciaNaContaDestino + valorDaTransferencia,
                contaDestino.getSaldo(), ACCEPTED_FLOAT_DELTA);
    }

    @Test
    public void testarTransferênciaDeValorDentroDoLimite() {
        // prepara o cenário de teste
        ContaCorrente contaOrigem = new ContaCorrente(123);
        float saldoAntesDaTransferenciaNaContaOrigem = contaOrigem.getSaldo();

        ContaCorrente contaDestino = new ContaCorrente(3465);
        float saldoAntesDaTransferenciaNaContaDestino = contaDestino.getSaldo();

        float valorDaTransferencia = saldoAntesDaTransferenciaNaContaOrigem +
                ContaCorrente.LIMITE_CHEQUE_ESPECIAL - 1;

        // chama o metodo desejado
        contaOrigem.transferir(valorDaTransferencia, contaDestino);

        assertEquals("O saldo na conta de destino deve diminuir (ficando negativo) " +
                        "após uma transferência que use o cheque especial",
                saldoAntesDaTransferenciaNaContaOrigem - valorDaTransferencia,
                contaOrigem.getSaldo(), ACCEPTED_FLOAT_DELTA);
        assertEquals("O saldo na conta de destino deve aumentar após receber " +
                        "uma transferência",
                saldoAntesDaTransferenciaNaContaDestino + valorDaTransferencia,
                contaDestino.getSaldo(), ACCEPTED_FLOAT_DELTA);
    }

    @Test
    public void testarTransferênciaDeValorAcimaDoLimite() {
        // prepara o cenário de teste
        ContaCorrente contaOrigem = new ContaCorrente(123);
        float saldoAntesDaTransferenciaNaContaOrigem = contaOrigem.getSaldo();

        ContaCorrente contaDestino = new ContaCorrente(3465);
        float saldoAntesDaTransferenciaNaContaDestino = contaDestino.getSaldo();

        float valorDaTransferencia = saldoAntesDaTransferenciaNaContaOrigem +
                ContaCorrente.LIMITE_CHEQUE_ESPECIAL + 50;

        // chama o metodo desejado
        contaOrigem.transferir(valorDaTransferencia, contaDestino);

        assertEquals("O saldo na conta de origem não deve ser modificado diante " +
                        "de uma tentativa de transferência acima do limite",
                saldoAntesDaTransferenciaNaContaOrigem,
                contaOrigem.getSaldo(), ACCEPTED_FLOAT_DELTA);
        assertEquals("O saldo na conta de destino não deve ser modificado diante " +
                        "de uma tentativa de transferência acima do limite",
                saldoAntesDaTransferenciaNaContaDestino,
                contaDestino.getSaldo(), ACCEPTED_FLOAT_DELTA);
    }

    @Test
    public void testarPremioDaCentesimaContaCriada() {
        for (int i = 1; i <= 100; i++) {
            ContaCorrente conta = new ContaCorrente(123);
            if (i < 100) {
                assertEquals(50, conta.getSaldo(), ACCEPTED_FLOAT_DELTA);
            } else {
                assertEquals("A centésima conta criada precisa ganhar um bprêmio de 1000 reais",
                        1050, conta.getSaldo(), ACCEPTED_FLOAT_DELTA);
            }
        }
    }
}