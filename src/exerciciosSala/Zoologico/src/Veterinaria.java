package exerciciosSala.Zoologico.src;

import java.util.ArrayList;

public class Veterinaria {

    ArrayList<Animal> bichos = new ArrayList<Animal>();

    public void cuidar(Animal bicho) {
        System.out.println("Cuidando do " + bicho);
        bicho.dormir();
        System.out.println("5 minutos depois...");
        System.out.println(bicho.emitirSom(30));
        bicho.emitirSom(10);
        bichos.add(bicho);
    }

    public Animal obterAnimalAtendido(int ordemAtendimento) {
        return bichos.get(ordemAtendimento - 1);
    }

    public ArrayList<Animal> obterPetsDoCliente(long cpfDoCliente) {
        ArrayList<Animal> bichosDoCliente = new ArrayList<Animal>();
        for (Animal bicho : bichos) {
            if (bicho.getCpfDoDono() == cpfDoCliente && !bichosDoCliente.contains(bicho)) {
                bichosDoCliente.add(bicho);
            }
        }
        return bichosDoCliente;
    }




}
