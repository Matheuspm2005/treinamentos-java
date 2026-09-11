public class Principal {

    public static void main(String[] args) {

        ContaCorrente contaDoFulano = new ContaCorrente(5425);
        ContaCorrente contaDaCicrana = new ContaCorrente(2132);

        contaDoFulano.idBanco = 6;

        System.out.println("contaDoFulano.idBanco = " + contaDoFulano.idBanco);
        System.out.println("contaDaCicrana.idBanco = " + contaDaCicrana.idBanco);
        System.out.println("ContaCorrente.idBanco = " + ContaCorrente.idBanco);

        System.out.println("ContaCorrente.quantContasCriadas = " +
                contaDoFulano.getQuantContasCriadas());

//        System.out.println("saldo = " + contaDoFulano.saldo);
//        System.out.println("cpf = " + contaDoFulano.cpf);
//        System.out.println("senha = " + contaDoFulano.senha);

//        System.out.println("Vou modificar o saldo (quebrando o encapsulamento)");
//        contaDoFulano.saldo -= 7000;  // AGORA IRIA FALHAR!!!!!! NÃO POSSO MAIS QUEBRAR O ENCAPSULAMENTO!!!
        contaDoFulano.sacar(30);
        contaDoFulano.imprimirExtrato();

        System.out.println("saldo = " + contaDoFulano.getSaldo());

          // não poderá jamais ser modificado (constante)
    }

}
